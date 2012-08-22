principal = 500000
principal = float(principal)

principal_interest = 0.05
principal_interest = float(principal_interest)

tuition = 34986
tuition = float(tuition)

tuition_interest = 0.041
tuition_interest = float(tuition_interest)

year = 1
year = int(year)
students = 0


while principal > tuition:
	if year % 2 != 0:
		principal = principal - tuition
		students = students + 1		
	annual_interest = principal * principal_interest
	annual_tuition_interest = tuition * tuition_interest
	year = year + 1
	principal = principal + annual_interest
	tuition = tuition + annual_tuition_interest
print students
