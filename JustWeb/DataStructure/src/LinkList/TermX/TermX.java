package LinkList.TermX;


public class TermX implements Comparable<TermX>,Addible<TermX> {
    protected int coef,xexp;   //系数 x的指数
    public TermX(int coef,int xexp){   //构造一项
        this.coef = coef;
        this.xexp = xexp;
    }

    public TermX(TermX term){//拷贝构造方法
        this.coef = term.coef;
        this.xexp = term.xexp;
    }

    public TermX(String termstr){

    }

    public String toString(){//返回对应的一项 系数x^指数 的省略形式字符串 省略形式说明同TermX(String)方法
        String termstr = "";
        termstr = this.coef+"x^"+this.xexp;
        if(this.coef == 1){
            termstr = "x^"+this.xexp;
        }else if(this.coef == -1){
            termstr = "-x^"+this.xexp;
        }

        if(this.xexp == 0){
            termstr += this.coef;
        }else if(this.xexp == 1){
            termstr = this.coef+"x";
        }

        return termstr;
    }


    public boolean equals(Object obj){  //比较两项是否相等
        obj = (TermX)obj;
        return this.coef == ((TermX) obj).coef && this.xexp == ((TermX) obj).xexp;
    }

    public int compareTo(TermX term){
            return (this.coef<term.coef) ? -1:(this.coef==term.coef ? 0 : 1);
    }


    public void add(TermX term){
        if(this.xexp == term.xexp){
            this.coef += term.coef;
        }

    }

    public boolean removable(){
        return this.coef == 0;
    }

}
