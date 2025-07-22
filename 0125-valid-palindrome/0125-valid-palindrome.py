class Solution(object):
    def isPalindrome(self, s):
        # נשמור רק תווים אלפאנומריים ונמיר לאותיות קטנות
        filtered = [c.lower() for c in s if c.isalnum()]

        # נבדוק פלינדרום רגיל על הרשימה החדשה
        left = 0
        right = len(filtered) - 1

        while left < right:
            if filtered[left] != filtered[right]:
                return False
            left += 1
            right -= 1

        return True

        