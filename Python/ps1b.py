#Problem Set 1 Part II
#Name: Mike Brown
#Collaborators: N/A
#Time:0:00
#The current annual tuition is $34,986
#Tuition goes p 4.1% a year
#Principal will be invested so that it earns 5% a year
#write a program that calculates and prints the total number of students
#this gift will support and the tuition paid
#for the last student. (1 every other year until $=0)
gift_amount = 500000.00
tuition = 34986.00
rate_increase = .041
interest_gained = .05
student_count = 0
year = -1
iteration = 0
while gift_amount > 0 :
	print "There is $ " + str(gift_amount) + " remaining"
	if  year < 0:
		gift_amount = (gift_amount - tuition)
		student_count += 1
		print "student number " + str(student_count) + " was given $ " + str(tuition) + " this year"
		tuition = ((tuition * rate_increase) + tuition)
		print "tuition is now: " + str(tuition)
		gift_amount = ((gift_amount * interest_gained) + gift_amount)
		year = 1
	else:
		gift_amount = ((gift_amount * interest_gained) + gift_amount)
		tuition = ((tuition * rate_increase) + tuition)
		year = -1
