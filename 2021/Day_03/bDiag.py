from collections import Counter
#my_file = "C:\\Users\\ifels\\Documents\\GitHub\\Advent-of-Code\\2021\\Day_03\\input.txt"
#content_list = my_file.readlines().strip().split('\n')
content_list = [x for x in open('C:\\Users\\ifels\\Documents\\GitHub\\Advent-of-Code\\2021\\Day_03\\input.txt').read().strip().split('\n')]

print(content_list)

"""
PART 1
theta = ''
epsilon = ''
for i in range(len(content_list[0])):
	common = Counter([x[i] for x in content_list])
	if common['0'] > common['1']:
		theta += '0'
		epsilon += '1'
	else:
		theta += '1'
		epsilon += '0'
print(int(theta,2)*int(epsilon,2))
"""

theta = ''
epsilon = ''
for i in range(len(content_list[0])):
	common = Counter([x[i] for x in content_list])
	if common['0'] > common['1']:
	    content_list = [x for x in content_list if x[i] == '0']
	else:
		content_list = [x for x in content_list if x[i] == '1']
	theta = content_list[0]
print(common)
content_list = [x for x in open('C:\\Users\\ifels\\Documents\\GitHub\\Advent-of-Code\\2021\\Day_03\\input.txt').read().strip().split('\n')] #reset
for i in range(len(content_list[0])):
	common = Counter([x[i] for x in content_list])

	if common['0'] > common['1']:
		content_list = [x for x in content_list if x[i] == '1']
	else:
		content_list = [x for x in content_list if x[i] == '0']
	if content_list:
		epsilon = content_list[0]
print(int(theta,2)*int(epsilon,2)) #int(x, BASE)


"""
i = 0
nums0= 0
nums1=0
convList = []
leng = len(content_list)
print("Length of list: ", leng)
count = 0
for i in content_list:
    count += 1
    print("Ayo i is {}".format(count))
    if(i[0] == '0'):
        nums0 += 1
    elif(i[0] == '1'):
        nums1+= 1
    if(int(count) == 12):
        print("index i at: {}".format(i))
        count = 0
        print("Nums 0 & Nums 1: {}, {}".format(nums0,nums1))
        if(nums0 > nums1):
            convList.append('0')
        else:
            convList.append('1')
        nums0 = 0
        nums1 = 0

print(nums0)
print(nums1)
print(convList)
"""
    
