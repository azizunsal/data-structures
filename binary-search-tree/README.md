## Binary Search Trees

### Design

We can extend linked list implementation by adding a new node.

### Traversing the Tree

There are 3 different traversal for binary search trees; `inorder`, `preorder` and `postorder`.

#### Inorder Traversal

1. Visit the left node first,
2. Visit the current node,
3. And then visit the right node.

#### Preorder Traversal

1. Visit the current node first,
2. Visit the left node,
3. And then visit the right node.

#### Postorder Traversal

1. Visit the left node,
2. Visit the right node,
3. And then visit the current node first.

### Tree Shape

Tree shape depends on order of insertions.

**Best Case:**

                  H
               /     \
              C       S
             / \     /  \
            A   E   R    X

**Typical Case:**

              S
            /   \
           E     X
          /   \       
         A     R
          \    /      
           C  H

**Worst Case:**
    
    A
     \
      C
       \
        E
         \
          H
           \
            R
             \  
              S
               \
                X

**Node that:** If values are in natural order what we got is the worst case scenario!

