class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        
        groups = {}

        for i,s in enumerate(strs):
            counts = [0] * 26
            for  c in s:
                counts[ord(c)-ord('a')] += 1

            key = tuple(counts)
            
            if key not in groups:
                groups[key] = []
            groups[key].append(s)

        return list(groups.values())


