import java.util.*;
class JavaStack {

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();


        while (sc.hasNext()) {
            String input=sc.next();
            char [] arr = input.toCharArray();
            for(int i = 0; i < arr.length; i++) {
                list.add(String.valueOf(arr[i]));
            }

            if(list.size()%2 == 0 && !list.isEmpty() && (list.get(0).equals("{") ||
                    list.get(0).equals("(") ||
                    list.get(0).equals("["))) {
                int count = 0;
                for(int i = 0; i < list.size(); i++) {
                    String tmp = list.get(i);
                    if (tmp.equals("{")) {
                        if(!list.get(i+1).equals("}")) {
                            for (int j = 1; j < list.size(); j++) {
                                if(list.get(j).equals("}") && j-i % 2 != 0) {
                                    count = count  + 2;
                                }
                            }
                        } else {
                            count = count  + 2;
                        }
                    } else if (tmp.equals("[")) {
                        if(!list.get(i+1).equals("]")) {
                            for (int j = 1; j < list.size(); j++) {
                                if(list.get(j).equals("]") && j-i % 2 != 0) {
                                    count = count  + 2;
                                }
                            }
                        } else {
                            count = count  + 2;
                        }
                    } else if (tmp.equals("(")) {
                        if(!list.get(i+1).equals(")")) {
                            for (int j = 1; j < list.size(); j++) {
                                if(list.get(j).equals(")") && j-i % 2 != 0) {
                                    count = count  + 2;
                                }
                            }
                        } else {
                            count = count  + 2;
                        }
                    }
                }
                if(count == 0 || list.size() > count) {
                    System.out.println(false);
                }
                else {
                    System.out.println(true);
                }
                list.clear();
            } else {
                System.out.println(false);
                list.clear();
            }
        }

    }
}