package top.gongyanhui.domain;

public class Hero {
    private int no;
    private String name;
    private Hero left;
    private Hero right;

    //构造器
    public Hero(int no, String name) {
        this.no = no;
        this.name = name;
    }

    /* Getter and Setter */
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

    public Hero getLeft() {
        return left;
    }

    public void setLeft(Hero left) {
        this.left = left;
    }

    public Hero getRight() {
        return right;
    }

    public void setRight(Hero right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历的方法
    public void preOrder() {
        System.out.println(this);
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        //递归向左子树中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        //递归向右子树中序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后续遍历
    public void postOrder() {
        //递归向左子树后序遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        //递归向右子树后序遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * 前序遍历查找
     * @param no 查找no
     * @return   如果找到就返回该节点，没有找到就返回null
     */
    public Hero preOrderSearch(int no) {
        if (this.no == no) {    //比较当前节点是不是
            return this;
        }
        //如果不是，则判断当前节点的左子节点是否为空，不为空则递归前序查找 如果左递归前序查找找到节点就返回
        Hero resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {  //说明左子树找到
            return resNode;
        }
        //左递归前序查找，找到节点 则返回 否则继续判断
        //当前的节点的右子节点是否为空 如果不为空，则继续向右递归前序查找
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        //最后不管有没有查找到 都必须返回
        return resNode;
    }

    //中序遍历查找
    public Hero infixOrderSearch(int no) {
        //判断当前节点的左子节点是否为空 如果不为空 则递归中序查找
        Hero resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {  //如果找到 直接返回
            return resNode;
        }
        //如果没有找到 就和当前根节点比较 如果是则返回当前节点
        if (this.no == no) {
            return this;
        }
        //否则继续进行右递归的中序查找
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //后序查找
    public Hero postOrderSearch(int no) {
        Hero resNode = null;
        //判断当前节点的左子节点是否为空 如果不为空 则递归后序查找
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {  //说明在左子树找到
            return resNode;
        }
        //如果左子树没有找到 则向右子树递归进行后序遍历查找
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //如果左子树都没有找到，就判断当前节点是不是
        if (this.no == no) {
            return this;
        }
        return resNode;
    }

    /**
     * 删除节点
     *  1 如果删除的节点是叶子节点，则删除该节点
     *  2 如果删除的节点是非叶子节点，则删除该子树
     * @param no
     */
    public void delNode(int no) {
        //如果当前节点的左子节点不为空，并且左子节点就是要删除的节点，就将this.left = null并且返回
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        //如果当前节点的右子节点不为空，并且右子节点就是要删除的节点，就将this.right = null并且返回
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        //向左子树进行递归删除
        if (this.left != null) {
            this.left.delNode(no);
        }
        //向右子树进行递归删除
        if (this.right != null) {
            this.right.delNode(no);
        }
    }
}
