import csv
import random
 
with open('users.csv','w',newline="") as file:
        fieldnames = ['userName','email','name']
        writer = csv.DictWriter(file, fieldnames=fieldnames)
        writer.writeheader()
        data = {}  
        
        for i in range(150):
            value = str(random.randint(1,10000))
            data['userName'] = "user" + value
            data['email'] = "user" + value + "@gmail.es"
            data['name'] = "user" + value
            writer.writerow(data)

            
   

       