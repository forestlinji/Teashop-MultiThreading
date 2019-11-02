package teaShop;

import exception.SoldOutException;
import ingredient.Bubble;
import ingredient.Coconut;
import ingredient.Ingredient;
import milkTea.MilkTea;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TeaShop {
    List<Bubble> bubbleList;
    List<Coconut> coconutList;

    public TeaShop() {
        bubbleList=new ArrayList<>();
        coconutList=new ArrayList<>();
    }

    public List<Bubble> getBubbleList() {
        return bubbleList;
    }

    public List<Coconut> getCoconutList() {
        return coconutList;
    }
    private void addBubble(Bubble bubble){
        bubbleList.add(bubble);
    }
    private void addCoconut(Coconut coconut){
        coconutList.add(coconut);
    }

    public void stock(Ingredient ingredient){
        if(ingredient instanceof Bubble){
            addBubble((Bubble)ingredient);
        }
        else if(ingredient instanceof Coconut){
            addCoconut(((Coconut)ingredient));
        }
    }

    public void sell(String teaName, String ingredientName){
        //售卖前先删除过期配料
        deleteOverdueIngredient();
        try{
            if(ingredientName.equals("Bubble")){
                //无对应配料
                if(bubbleList.isEmpty()) throw new SoldOutException("Bubble");

                MilkTea milkTea=new MilkTea(teaName,bubbleList.get(0));
                bubbleList.remove(0);
                System.out.println(milkTea+"\n"+"sold successfully");

            }
            else if(ingredientName.equals("Coconut")){
                //无对应配料
                if(coconutList.isEmpty()) throw new SoldOutException("Coconut");

                MilkTea milkTea=new MilkTea(teaName,coconutList.get(0));
                coconutList.remove(0);
                System.out.println(milkTea+"\n"+"sold successfully");
            }
        }catch (SoldOutException e){
            e.printStackTrace();
        }
    }

    /**
     * 删除过期配料
     */
    private void deleteOverdueIngredient(){
        while(!bubbleList.isEmpty()){
            Bubble firstBubble=bubbleList.get(0);
            if(firstBubble.getExpireTime().compareTo(Calendar.getInstance())<0){
                bubbleList.remove(0);
            }
            else break;
        }
        while(!coconutList.isEmpty()){
            Coconut firstCoconut = coconutList.get(0);
            if(firstCoconut.getExpireTime().compareTo(Calendar.getInstance())<0){
                coconutList.remove(0);
            }
            else break;
        }
    }
}