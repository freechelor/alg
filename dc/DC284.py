def getCousins(root, child):
    queue = []
    res = []
    if root is None or child is None:
        return None
    if root.left is None and root.right is None:
        return None
    queue.append(root)
    size = len(queue)
    found = False
    while len(queue)>0:
        res = []
        while size>0:
            parent = queue.pop(0)
            if parent is None:
                continue
            if parent.left is child or parent.right is child:
                #print(parent.left.value, parent.right.value, child.value)
                found = True
            else:
                #print(id(parent.left))
                #print(id(parent.right))
                if parent.left is not None:
                    print('left child', parent.left.value)
                    res.append(parent.left)
                    queue.append(parent.left)
                if parent.right is not None:
                    print('right child', parent.right.value)
                    res.append(parent.right)
                    queue.append(parent.right)
            size -= 1
        if found:
            break
        size = len(queue)

    return res


class TreeNode:
    #left = None
    #right = None

    def __init__(self, v):
        self.value = v
        self.left = None
        self.right = None

root = TreeNode(1);
n1 = TreeNode(2);
n2 = TreeNode(3);
n3 = TreeNode(4);
n4 = TreeNode(5);
n5 = TreeNode(6);
n6 = TreeNode(6);
n7 = TreeNode(7);
n8 = TreeNode(8);
n9 = TreeNode(9);
n10 =TreeNode(10);
n11 = TreeNode(11);
root.left = n1;
root.right = n2;
n1.left = n3;
n1.right = n4;
n2.right = n5;
n3.left = n6;
n4.left = n7;
n4.right = n8;
n5.left = n9;
n5.right = n10;
for r in getCousins(root, n6):
    if r is not None:
        print(r.value)

