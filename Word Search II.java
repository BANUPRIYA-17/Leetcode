class Solution:
    def findWords(self, board, words):
       
        trie = {}
        for word in words:
            node = trie
            for char in word:
                node = node.setdefault(char, {})
            node['#'] = word  # End of word marker

        rows, cols = len(board), len(board[0])
        result = []

        def dfs(r, c, node):
            char = board[r][c]
            if char not in node:
                return
            nxt = node[char]

           
            if '#' in nxt:
                result.append(nxt['#'])
                del nxt['#']  # Avoid duplicates

        
            board[r][c] = '*'
            for dr, dc in [(1,0), (-1,0), (0,1), (0,-1)]:
                nr, nc = r + dr, c + dc
                if 0 <= nr < rows and 0 <= nc < cols and board[nr][nc] != '*':
                    dfs(nr, nc, nxt)
            board[r][c] = char  # Restore

           
            if not nxt:
                node.pop(char)

       
        for r in range(rows):
            for c in range(cols):
                dfs(r, c, trie)

        return result



board1 = [["o","a","a","n"],
          ["e","t","a","e"],
          ["i","h","k","r"],
          ["i","f","l","v"]]
words1 = ["oath","pea","eat","rain"]
print(Solution().findWords(board1, words1)) 

board2 = [["a","b"],["c","d"]]
words2 = ["abcb"]
print(Solution().findWords(board2, words2)) 
