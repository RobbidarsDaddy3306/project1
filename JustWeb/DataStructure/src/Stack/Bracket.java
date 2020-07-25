package Stack;

public class Bracket {   //检查infix表达式中的圆括号是否匹配 若匹配 返回空串 否则返回错误信息
    public static String isMatched(String infix){
        Stack<String> stack = new SeqStack<String>(infix.length());  //声明接口对象 引用实现stack接口的顺序栈实例

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            switch (ch){
                case '(' : stack.push(ch+"");break;

                case ')' : if(stack.isEmpty() || !stack.pop().equals("(")){ return "期望(";}break;

            }
        }
        return (stack.isEmpty())? "" : "期望)";
    }

    public static void main(String[] args) {
        String infix = "((1+2)*3+4))(";
        System.out.println(infix+" , 编译错误:"+Bracket.isMatched(infix));
    }


}
