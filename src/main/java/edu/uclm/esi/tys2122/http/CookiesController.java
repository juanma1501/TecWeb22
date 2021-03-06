package edu.uclm.esi.tys2122.http;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The type Cookies controller.
 */
@CrossOrigin
public abstract class CookiesController {
	/**
	 * The Cookie name.
	 */
	public final String COOKIE_NAME = "laCookie";
	/**
	 * The Cookie path.
	 */
	public final String COOKIE_PATH = "/";

	/**
	 * Read or create cookie cookie.
	 *
	 * @param request  the request
	 * @param response the response
	 * @return the cookie
	 */
	protected Cookie readOrCreateCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies==null)
			return createCookie(response);
		Cookie cookie = findCookie(cookies);
		if (cookie==null)
			cookie = createCookie(response);
		return cookie;
	}

	private Cookie findCookie(Cookie[] cookies) {
		for (Cookie cookie : cookies)
			if (cookie.getName().equals(COOKIE_NAME))
				return cookie;
		return null;
	}

	private Cookie createCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie(COOKIE_NAME, UUID.randomUUID().toString());
		cookie.setPath(COOKIE_PATH);
		cookie.setMaxAge(30*24*60*60);
		response.addCookie(cookie);
		return cookie;
	}
}
