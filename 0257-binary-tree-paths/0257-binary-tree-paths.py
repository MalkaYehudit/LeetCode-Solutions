class Solution(object):
    def binaryTreePaths(self, root):
        if not root:
            return []

        result = []

        def dfs(node, path):
            if not node.left and not node.right:  # אם הגעת לעלה
                result.append(path)
                return

            if node.left:
                dfs(node.left, path + "->" + str(node.left.val))
            if node.right:
                dfs(node.right, path + "->" + str(node.right.val))

        dfs(root, str(root.val))
        return result
