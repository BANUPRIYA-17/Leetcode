#include <stdio.h>


struct TreeNode* lowestCommonAncestor(struct TreeNode* root, struct TreeNode* p, struct TreeNode* q) {
    
    struct TreeNode* currentNode = root;
    
    while (currentNode != NULL) {
        if (p->val < currentNode->val && q->val < currentNode->val) {
            currentNode = currentNode->left;
        }
        else if (p->val > currentNode->val && q->val > currentNode->val) {
            currentNode = currentNode->right;
        }
        else {
            return currentNode;
        }
    }
    return NULL;
}
