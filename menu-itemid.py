import random
import datetime
import calendar
file = open("testset.txt","w+")
#ffc = ["1","2","3"]
item = ["Burger","Pizza","Hamburger","Pasta","Popcorn"]
d = ["YES", "NO"]
a = ["Young","Adult","Senior"]
#cuisine = ["101","102","103","104","105"]
#tid = 0
#custid = 0
#offer = ["11","12","13","14","15"]

#pay = ["YES","N0","NO","NO"]
#t = 1
#id = 0
for j in range(500) :
    # menu -
    #p = random.randrange(1,5)
    #q = random.random()
    #a = [111,"Burger",110,p,q]
    #b = [112, "Pizza", 180,p,q]
    #c = [113, "Hamburger",130,p,q]
    #d = [114,"Pasta", 200,p,q]
    #e = [115,"Popcorn", 80,p,q]
    #f = [a,b,c,d,e]
    #g = random.choice(f)
    #file.write("insert into menu(item_id,item_name,price,review,healthindex) values('" +str(g[0])+ "','" +str(g[1])+ "','" +str(g[2])+ "','" +str(g[3])+ "','" +str(g[4])+"'); \n ")   
    
    #payment -
    #random.shuffle(pay)
    #file.write("insert into payment(UPI,Creditcard,Debitcard,Cash) values('" +str(pay[0])+ "','" +str(pay[1])+ "','" +str(pay[2])+ "','" + str(pay[3])+ "'); \n ")
   
    #customer 2 -
    #add = random.randrange(100,10000)
    #start_date = datetime.date(1960,1,1)
    #end_date = datetime.date(2012,1,1)
    #days_between_dates = (end_date - start_date).days
    #random_days = random.randrange(days_between_dates)
    #dob = start_date + datetime.timedelta(days = random_days)
    #file.write("insert into customer(address_id,dob) values('" +str(add)+ "','" +str(dob)+ "'); \n ")

    #timestamp -
    
    #start_date = datetime.date(2020,1,1)
    #end_date = datetime.date(2020,12,31)
    #days_between_dates = (end_date - start_date).days
    #random_days = random.randrange(days_between_dates)
    #d = start_date + datetime.timedelta(days = random_days)
    #time = str(random.randrange(0,24)) +":"+ str(random.randrange(0,60))
    #ts = str(d) +" "+ str(time)
    #t = str(time)
    age = random.choice(a)
    i = random.choice(item)
    de = random.choice(d)
    file.write("insert into custanalysis(age,item,decision) values('" +str(age)+ "','" +str(i)+ "','" +str(de)+ "'); \n ")

    #fact table -
    #chid = random.choice(ffc)
    #iid = random.choice(item)
    #cuid = random.choice(cuisine)
    #tid = tid + 1
    #custid = custid + 1

    #start_date = datetime.date(2020,1,1)  
    #end_date = datetime.date(2020,12,31)
    #days_between_dates = (end_date - start_date).days
    #random_days = random.randrange(days_between_dates)
    #d = start_date + datetime.timedelta(days = random_days)
    #ts = str(d) +" "+ str(random.randrange(0,24)) +":"+ str(random.randrange(0,60))

    #oid = random.choice(offer)

    #file.write("insert into fact_table(chain_id,item_id,cuisine_id,transaction_id,customer_id,timestamp_id,offer_id) values('" +str(chid)+ "','" +str(iid)+ "','" +str(cuid)+ "','" +str(tid)+ "','" +str(custid)+ "','" +str(ts)+ "','" +str(oid)+ "'); \n")