# Binary Trees

## Some Terms

### Complete Binary Tree

A complete binary tree is a binary tree in which every level except _possibly_ the last, is completely filled,
and all nodes in the last level as far left as possible. **A complete binary can be efficiently represented using an
array.**

### Full Binary Tree

A full binary tree is a binary tree in which all of the nodes have either zero or 2 offsprings.

### Balanced Binary Tree

A balanced binary tree is a binary tree structure in which the left and right subtrees of every node differ in
height by no more than 1.

## Design

We can extend linked list implementation by adding a new node.

#### An Example of BT

![BT_Image](./src/main/resources/BinaryTree.png)

## Tree Traversal

There are 2 different way of traversing a tree;

1. `dept-first`
2. `breadth-first`.

And 3 different kind of `depth-first` algorithm which are;

1. `inorder`,
2. `preorder`,
3. `postorder`.

### Breadth-First Traversal:

sfsdf

### Depth-First (Level Order) Traversal:

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

## Tree Shape

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

## TODOs

- [ ] Implement a basic binary tree.
- [ ] Create a helper method to construct a binary tree, from a given level-order fashioned array.
- [ ] Implement a binary tree with array as underlying data structure.