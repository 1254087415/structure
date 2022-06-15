package com.zab.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        
        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);
        binaryTree.setRoot(root);
        
        System.out.println("前序遍历");
        binaryTree.preOrder();
        
        System.out.println("中序遍历");
        binaryTree.infixOrder();
        
        System.out.println("后序遍历");
        binaryTree.postOrder();
        
        System.out.println("前序查找");
        HeroNode heroNode = binaryTree.preSearch(5);
        System.out.println(heroNode);
        
        System.out.println("中序查找");
        HeroNode heroNode1 = binaryTree.infixSearch(5);
        System.out.println(heroNode1);
    
        System.out.println("后序查找");
        HeroNode heroNode2 = binaryTree.postSearch(3);
        System.out.println(heroNode2);
    
        System.out.println("删除节点前------前序遍历");
        binaryTree.preOrder();
        binaryTree.delNode(5);
        System.out.println("删除节点后------前序遍历");
        binaryTree.preOrder();
    }
}

class BinaryTree {
    private HeroNode root;
    
    public void setRoot(HeroNode root) {
        this.root = root;
    }
    
    // 前序遍历
    public void preOrder() {
        if (root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    
    // 中序遍历
    public void infixOrder() {
        if (root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    
    // 后序遍历
    public void postOrder() {
        if (root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    
    // 前序查找
    public HeroNode preSearch(int no) {
        if (root != null) {
            return this.root.preOrderSearch(no);
        } else {
            return null;
        }
    }
    
    // 前序查找
    public HeroNode infixSearch(int no) {
        if (root != null) {
            return this.root.infixOrderSearch(no);
        } else {
            return null;
        }
    }
    
    // 后序查找
    public HeroNode postSearch(int no) {
        if (root != null) {
            return this.root.postOrderSearch(no);
        } else {
            return null;
        }
    }
    
    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                this.root.delNode(no);
            }
        } else {
            System.out.println("没有");
        }
    }
    
    
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    
    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }
    
    public int getNo() {
        return no;
    }
    
    public void setNo(int no) {
        this.no = no;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public HeroNode getLeft() {
        return left;
    }
    
    public void setLeft(HeroNode left) {
        this.left = left;
    }
    
    public HeroNode getRight() {
        return right;
    }
    
    public void setRight(HeroNode right) {
        this.right = right;
    }
    
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
    
    // 前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
    
    // 中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
    
    // 后序遍历
    public void postOrder() {
        if (this.right != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }
    
    /**
     * 前序查找
     *
     * @param no 查找的编码
     * @return 如果找到就返回
     */
    public HeroNode preOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }
        HeroNode res = null;
        if (this.left != null) {
            res = this.left.preOrderSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (this.right != null) {
            res = this.right.preOrderSearch(no);
        }
        return res;
    }
    
    /**
     * 中序查找
     *
     * @param no 查找的编码
     * @return 查找的节点
     */
    public HeroNode infixOrderSearch(int no) {
        HeroNode res = null;
        if (this.left != null) {
            res = this.left.infixOrderSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            res = this.right.infixOrderSearch(no);
        }
        return res;
    }
    
    /**
     * 后序查找
     * @param no 查找的编码
     * @return 查找的节点
     */
    public HeroNode postOrderSearch(int no) {
        HeroNode res = null;
        if (this.left != null) {
            res = this.left.postOrderSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (this.right != null) {
            res = this.right.postOrderSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (this.no == no) {
            return this;
        }
        return null;
    }
    
    /**
     * 删除节点
     *
     * @param no 结点编号
     */
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
        }
        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }
    }
}


