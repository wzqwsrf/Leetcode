# Add Binary
class Solution:
    # @param a, a string
    # @param b, a string
    # @return a string
    def addBinary(self, a, b):
        len1 = len(a)
        len2 = len(b)
        if len1 > len2:
            maxLen = len1
        else:
            maxLen = len2
        list = [0 for i in range(maxLen + 1)]
        k = maxLen
        while len1 > 0 and len2 > 0:
            list[k] += int(a[len1-1]) + int(b[len2-1])
            if list[k] >= 2:
                list[k] -= 2
                list[k-1] += 1
            len1 -= 1
            len2 -= 1
            k -= 1
        while len1 > 0:
            list[k] += int(a[len1-1])
            if list[k] >= 2:
                list[k] -= 2
                list[k-1] += 1
            len1 -=1
            k -= 1
        while len2 > 0:
            list[k] += int(b[len2-1])
            if list[k] >= 2:
                list[k] -= 2
                list[k-1] += 1
            len2 -= 1
            k -= 1
        list = [str(e) for e in list]
        if list[0] == '0':
            return "".join(list[1:])
        else:
            return "".join(list)

        
