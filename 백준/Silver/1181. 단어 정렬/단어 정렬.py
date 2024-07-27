
count = int(input())

words_set= set()

for index in range(count):
    word1 = input()
    words_set.add(word1)

def sort_key(x) :
    return len(x), x

sorted_words_list = sorted(words_set, key=sort_key)
for word2 in sorted_words_list:
    print(word2)
