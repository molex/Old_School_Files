#Problem Set 1 
#Name: Mike Brown
#Collaborators: N/A
#Time:0:35
#
#Computes how much interest is earned on a given amount of Principa;.
principal = float(raw_input('Enter principal: '))
interest_rate = float(raw_input('Enter Interest rate percent: '))
years = int(raw_input('Enter the number of years: '))
tot_Interest = 0.0
cur_year = 0
while cur_year < years:
	annual_Interest = principal * (interest_rate * .01)
	tot_Interest= tot_Interest + annual_Interest
	principal = principal + annual_Interest
	cur_year = cur_year +1
print 'Total interest in ' + str(years) + ' year(s) : $' + str(tot_Interest)
