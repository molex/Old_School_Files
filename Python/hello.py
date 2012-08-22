a = 1
s = 0
print 'Enter Numbers to add to the sum.'
print 'Enter 0 to quit.'
while a != 0:
    print 'Current Sum: ', s
    a = raw_input('Number? ')
    a = float(a)
    s += a
print 'Total Sum = ',s
