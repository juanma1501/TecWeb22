package edu.uclm.esi.tys2122.junit;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Random;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import static org.junit.jupiter.api.Assertions.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import edu.uclm.esi.tys2122.MvcTestCase;

class junitTest  extends MvcTestCase{

    @Test
    void JupTest() throws Exception{
        JSONObject [] users = registerTest();
        HttpSession [] sessions = loginTest(users[0], users[1]);
        changePwdTest(users[0]);
        playGameTest(sessions[0], users[0], sessions[1], users[1]);
    }

    private JSONObject [] registerTest() throws Exception {
        JSONObject [] users = new JSONObject [2];
        JSONObject u = creUser("normal");
        JSONObject u2 = creUser("normal");

        // Correct Register {Everything is correct}
        doPut("/user/register", null,
                "userName", u.getString("name"),
                "email", u.getString("email"),
                "pwd1", u.getString("pwd"),
                "pwd2", u.getString("pwd")
        ).andExpect(status().isOk());

        doPut("/user/register", null,
                "userName", u2.getString("name"),
                "email", u2.getString("email"),
                "pwd1", u2.getString("pwd"),
                "pwd2", u2.getString("pwd")
        ).andExpect(status().isOk());

        // Incorrect Register {Empty fields}
        doPut("/user/register", null,
                "userName", u.getString("name")
        ).andExpect(status().is4xxClientError());

        // Incorrect Register {Not matching passwords}
        doPut("/user/register", null,
                "userName", u.getString("name"),
                "email", u.getString("email"),
                "pwd1", u.getString("pwd"),
                "pwd2", " "
        ).andExpect(status().is4xxClientError());

        // Incorrect Register {The user already exists}
        doPut("/user/register", null,
                "userName", u.getString("name"),
                "email", u.getString("email"),
                "pwd1", u.getString("pwd"),
                "pwd2", u.getString("pwd")
        ).andExpect(status().is4xxClientError());

        users[0] = u;
        users[1] = u2;
        return users;
    }

    private HttpSession [] loginTest(JSONObject u, JSONObject u2) throws Exception {
        HttpSession [] sessions = new HttpSession [2];
        JSONObject g = creUser("google");

        // Correct Normal Login {Everything is correct}
        HttpSession sesU = doPost("/user/login", null,
                "name", u.getString("name"),
                "pwd", u.getString("pwd")
        ).andExpect(status().isOk())
                .andReturn().getRequest().getSession();

        // Correct Normal Login user 2 {Everything is correct}
        HttpSession sesU2 = doPost("/user/login", null,
                "name", u2.getString("name"),
                "pwd", u2.getString("pwd")
        ).andExpect(status().isOk())
                .andReturn().getRequest().getSession();

        // Correct Google Login {Everything is correct}
        doPost("/user/login", null,
                "name", g.getString("name"),
                "email", g.getString("email"),
                "id", g.getString("id"),
                "type", g.getString("type")
        ).andExpect(status().isOk());

        // Incorrect Normal Login {Incorrect password}
        doPost("/user/login", null,
                "name", u.getString("name"),
                "pwd", u.getString("pwd")+"as"
        ).andExpect(status().is4xxClientError());

        sessions[0] = sesU;
        sessions[1] = sesU2;

        return sessions;
    }

    private void changePwdTest(JSONObject u) throws Exception {

        // Correct Reset Password {Everything is correct}
        doPost("/user/resetPassword", null,
                "email", u.getString("email")
        ).andExpect(status().isOk());

        // Incorrect Reset Password {No user has that email}
        doPost("/user/resetPassword", null,
                "email", "error@error.com"
        ).andExpect(status().is4xxClientError());

    }

    private void playGameTest(HttpSession sesU, JSONObject u, HttpSession sesU2, JSONObject u2) throws Exception {
        String response;
        JSONObject matchU;
        JSONObject matchU2;

        // Correct Get Games {Everything is correct}
        response = doGet("/games/getGames", sesU).andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        JSONArray jsaGames = new JSONArray(response);
        assertTrue(jsaGames.length() == 2);

        // Correct Join Game {Everything is correct}
        response = doGet("/games/joinGame/Tres en raya", sesU).andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        matchU = new JSONObject(response);

        // {Check if the parameters are correctly set}
        assertEquals("TictactoeMatch", matchU.getString("game"));
        assertFalse(matchU.getBoolean("ready"));
        assertEquals(1, matchU.getJSONArray("players").length());

        /*.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println(sesU);
        System.out.println(matchU.getString("id"));
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");*/


        // {Try move although there ins´t an opponent}
        doPost("games/move", sesU,
                "matchId",matchU.getString("id"),
                "x","1",
                "y", "1"
               )
                .andExpect(status().is4xxClientError())
                .andReturn().getResponse().getContentAsString();

        /*
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println(sesU2);
        System.out.println(sesU);
        System.out.println(matchU.getString("id"));
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
         */


        // Correct Join Game {Everything is correct}
        response = doGet("/games/joinGame/Tres en raya", sesU2).andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        matchU2 = new JSONObject(response);

        // {Check if the parameters are correctly set}
        assertEquals("TictactoeMatch", matchU2.getString("game"));
        assertTrue(matchU2.getBoolean("ready"));
        assertEquals(2, matchU2.getJSONArray("players").length());
        assertTrue(matchU.getString("id").equals(matchU2.getString("id")));

    }

    private JSONObject creUser(String type) {
        Random rand = new Random();
        String random = String.valueOf(rand.nextInt(999));
        JSONObject jso = new JSONObject();

        String id = UUID.randomUUID().toString();
        String name = "user" + random;
        String email = name + "@" + name + ".com";
        String pwd = name + "pass";

        jso.put("id", id);
        jso.put("name", name);
        jso.put("email", email);
        jso.put("pwd", pwd);
        jso.put ("type", type);

        return jso;
    }
}