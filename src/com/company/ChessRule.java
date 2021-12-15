package com.company;

import java.awt.event.MouseEvent;
import java.util.List;

public class ChessRule {
    //play操作的棋子 playQ:包含32个棋子的数组 me:鼠标点击对象 chessRegretList:操作记录,用于悔棋 man:操作对象判断鼠标点击棋子对象
    public void cannonRule(ChessmanBehavior play, ChessmanBehavior playQ[], MouseEvent me, List<ChessRegret> chessRegretList,int man){
        int count=0;//记录移动路径上是否有棋子
        int cx= me.getX();//点击的下一位置
        int cy= me.getY()+30;//有工具栏+30
        //判定移动为直线在点击框之内
        System.out.println("鼠标"+cx+" "+cy);
        System.out.println("棋"+play.getX()+" "+play.getY());
        if(cx-play.getX()>=0&&cx-play.getX()<57){
            for (int i = 56; i <=569 ; i+=57) {
                //遍历查询位置，找到要移动的位置
                if(cy-i>=0&&cy-i<57){
                    for (int j = 0; j < 32; j++) {
                        //?
                        if (playQ[j].getX()==play.getX()&&play.getName()!=playQ[j].getName()&&playQ[j].isVisible()){//是不是不显示
                            //上下移动
                            for (int k = i; k <play.getY()  ; k+=57) {
                                if(playQ[j].getY()==k){
                                    count++;
                                }
                            }
                            for (int k = play.getY(); k <i ; k+=57) {
                                if (playQ[j].getY() == k) {
                                    count++;
                                }
                            }
                        }
                    }
                if (count==0){
                    ChessRegret chessRegret=new ChessRegret();
                    chessRegret.man=man;//移动对象
                    chessRegret.cx=play.getX();
                    chessRegret.cy=play.getY();//移动之前的位置
                    chessRegretList.add(chessRegret);//记录
                    play.setBounds(play.getX(),i,55,55);//移动
                    play.playSounds();//声音
                    return;
                }
                }

            }
        }
        //左右移动
        if(cy-play.getY()>=0&&cy-play.getY()<57){
            for (int i = 24; i <=480 ; i+=57) {
                //遍历查询位置，找到要移动的位置
                if(cx-i>=0&&cx-i<57){
                    for (int j = 0; j < 32; j++) {
                        //?
                        if (playQ[j].getY()==play.getY()&&play.getName()!=playQ[j].getName()&&playQ[j].isVisible()){
                            //左右移动
                            for (int k = i; k <play.getX()  ; k+=57) {
                                if(playQ[j].getX()==k){
                                    count++;
                                }
                            }
                            for (int k = play.getX(); k <i ; k+=57) {
                                if (playQ[j].getX() == k) {
                                    count++;
                                }
                            }
                        }
                    }
                    if (count==0){
                        ChessRegret chessRegret=new ChessRegret();
                        chessRegret.man=man;//移动对象
                        chessRegret.cx=play.getX();
                        chessRegret.cy=play.getY();//移动之前的位置
                        chessRegretList.add(chessRegret);//记录
                        play.setBounds(i,play.getY(),55,55);//移动
                        play.playSounds();
                        return;
                    }
                }
            }
        }
    }
    public void carRule(ChessmanBehavior play, ChessmanBehavior playQ[], MouseEvent me, List<ChessRegret> chessRegretList,int man){
        int count=0;//记录移动路径上是否有棋子
        int cx= me.getX();//点击的下一位置
        int cy= me.getY()+30;//有工具栏+30
        //判定移动为直线在点击框之内
        if(cx-play.getX()>=0&&cx-play.getX()<57){
            for (int i = 56; i <=569 ; i+=57) {
                //遍历查询位置，找到要移动的位置
                if(cy-i>=0&&cy-i<57){
                    for (int j = 0; j < 32; j++) {
                        //?
                        if (playQ[j].getX()==play.getX()&&play.getName()!=playQ[j].getName()&&playQ[j].isVisible()){
                            //上下移动
                            for (int k = i; k <play.getY()  ; k+=57) {
                                if(playQ[j].getY()==k){
                                    count++;
                                }
                            }
                            for (int k = play.getY(); k <i ; k+=57) {
                                if (playQ[j].getY() == k) {
                                    count++;
                                }
                            }
                        }
                    }
                    if (count==0){
                        ChessRegret chessRegret=new ChessRegret();
                        chessRegret.man=man;//移动对象
                        chessRegret.cx=play.getX();
                        chessRegret.cy=play.getY();//移动之前的位置
                        chessRegretList.add(chessRegret);//记录
                        play.playSoundDown();
                        play.setBounds(play.getX(),i,55,55);//移动
                        //play.playSounds();
                        return;
                    }
                }
            }
        }
        if(cy-play.getY()>=0&&cy-play.getY()<57){
            for (int i = 24; i <=480 ; i+=57) {
                //遍历查询位置，找到要移动的位置
                if(cx-i>=0&&cx-i<57){
                    for (int j = 0; j < 32; j++) {
                        //?
                        if (playQ[j].getY()==play.getY()&&play.getName()!=playQ[j].getName()&&playQ[j].isVisible()){
                            //上下移动
                            for (int k = i; k <play.getX()  ; k+=57) {
                                if(playQ[j].getX()==k){
                                    count++;
                                }
                            }
                            for (int k = play.getX(); k <i ; k+=57) {
                                if (playQ[j].getX() == k) {
                                    count++;
                                }
                            }
                        }
                    }
                    if (count==0){
                        ChessRegret chessRegret=new ChessRegret();
                        chessRegret.man=man;//移动对象
                        chessRegret.cx=play.getX();
                        chessRegret.cy=play.getY();//移动之前的位置
                        chessRegretList.add(chessRegret);//记录

                        play.setBounds(i,play.getY(),55,55);//移动
                        play.playSoundDown();
                        return;
                    }
                }
            }
        }
    }
    public void horseRule(ChessmanBehavior play, ChessmanBehavior playQ[], MouseEvent me, List<ChessRegret> chessRegretList,int man){
        int ex=0,ey=0,move=0;
        ex=me.getX();
        ey=me.getY()+30;//点击的位置
        //判断位置,左上
//        System.out.println("鼠标"+ex+" "+ey);
//        System.out.println("棋"+play.getX()+" "+play.getY());
         if(play.getX()-ex>0&&play.getX()-ex<=57&&play.getY()-ey>57&&play.getY()-ey<=114){
             for (int i = 0; i < 32; i++) {
                 //撇腿
                if(playQ[i].died==false&&playQ[i].getX()==play.getX()&&playQ[i].getY()-play.getY()==-57){
                    move=1;
                    break;
                }
             }
             if(move==0){
                 ChessRegret chessRegret=new ChessRegret();
                 chessRegret.man=man;
                 chessRegret.cx= play.getX();
                 chessRegret.cy= play.getY();
                 chessRegretList.add(chessRegret);//记录操作
                 play.playSoundDown();
                 //移动棋子
                 play.setBounds(play.getX()-57,play.getY()-114,55,55);
             }
             return;
         }
         //右上
        if(ex-play.getX()>0&&ex-play.getX()<=114&&play.getY()-ey>57&&play.getY()-ey<=114){
            for (int i = 0; i < 32; i++) {
                //撇腿
                if(playQ[i].died==false&&playQ[i].getX()==play.getX() && playQ[i].getY()-play.getY()==-57){
                    move=1;
                    break;
                }
            }
            if(move==0){
                System.out.println("马右上");
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx= play.getX();
                chessRegret.cy= play.getY();
                chessRegretList.add(chessRegret);//记录操作
                play.playSoundDown();
                //移动棋子
                play.setBounds(play.getX()+57,play.getY()-114,55,55);
            }
            return;
        }
        //左下
        if(play.getX()-ex>0&&play.getX()-ex<=114&&ey-play.getY()>114&&ey-play.getY()<=171){
            for (int i = 0; i < 32; i++) {
                //撇腿
                if(playQ[i].died==false&&playQ[i].getX()==play.getX()&&playQ[i].getY()-play.getY()==57){
                    move=1;
                    break;
                }
            }
            if(move==0){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx= play.getX();
                chessRegret.cy= play.getY();
                chessRegretList.add(chessRegret);//记录操作
                play.playSoundDown();
                //移动棋子
                play.setBounds(play.getX()-57,play.getY()+114,55,55);
            }
            return;
        }
        //右下
        if(ex-play.getX()>0&&ex-play.getX()<=114&&ey-play.getY()>114&&ey-play.getY()-30<=171){
            System.out.println(ex+" "+play.getX());
            System.out.println(ey+" "+play.getY());
            for (int i = 0; i < 32; i++) {
                //撇腿
                if(playQ[i].died==false&&playQ[i].getX()==play.getX()&&playQ[i].getY()-play.getY()==57){
                    move=1;
                    break;
                }
            }
            if(move==0){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx= +play.getX();
                chessRegret.cy= play.getY();
                chessRegretList.add(chessRegret);//记录操作
                play.playSoundDown();
                //移动棋子
                play.setBounds(play.getX()+57,play.getY()+114,55,55);
            }
            return;
        }
        //左左上
        if(play.getX()-ex>57&&play.getX()-ex<=114&&play.getY()-ey>0&&play.getY()-ey<=57){
            for (int i = 0; i < 32; i++) {
                //撇腿
                if(playQ[i].died==false&&playQ[i].getX()-play.getX()==-57&&playQ[i].getY()==play.getY()){
                    move=1;
                    break;
                }
            }
            if(move==0){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx= play.getX();
                chessRegret.cy= play.getY();
                chessRegretList.add(chessRegret);//记录操作
                play.playSoundDown();
                //移动棋子
                play.setBounds(play.getX()-114,play.getY()-57,55,55);
            }
            return;
        }
        //左左下
        if(play.getX()-ex>57&&play.getX()-ex<=114&&ey-play.getY()-30>0&&ey-play.getY()-30<=57){
            for (int i = 0; i < 32; i++) {
                //撇腿
                if(playQ[i].died==false&&playQ[i].getX()-play.getX()==-57&&playQ[i].getY()==play.getY()){
                    move=1;
                    break;
                }
            }
            if(move==0){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx= play.getX();
                chessRegret.cy= play.getY();
                chessRegretList.add(chessRegret);//记录操作
                play.playSoundDown();
                //移动棋子
                play.setBounds(play.getX()-114,play.getY()+57,55,55);
            }
            return;
        }
        //右右上
        if(ex-play.getX()>114&&ex-play.getX()<=171&&play.getY()-ey>0&&play.getY()-ey<=57){
            for (int i = 0; i < 32; i++) {
                //撇腿
                if(playQ[i].died==false&&playQ[i].getX()-play.getX()==57&&playQ[i].getY()==play.getY()){
                    move=1;
                    break;
                }
            }
            if(move==0){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx= play.getX();
                chessRegret.cy= play.getY();
                chessRegretList.add(chessRegret);//记录操作
                play.playSoundDown();
                //移动棋子
                play.setBounds(play.getX()+114,play.getY()-57,55,55);
            }
            return;
        }
        //右右下
        if(ex-play.getX()>114&&ex-play.getX()<=171&&ey-play.getY()-30>0&&ey-play.getY()-30<=57){
            for (int i = 0; i < 32; i++) {
                //撇腿
                if(playQ[i].died==false&&playQ[i].getX()-play.getX()==57&&playQ[i].getY()==play.getY()){
                    move=1;
                    break;
                }
            }
            if(move==0){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx= play.getX();
                chessRegret.cy= play.getY();
                chessRegretList.add(chessRegret);//记录操作
                play.playSoundDown();
                //移动棋子
                play.setBounds(play.getX()+114,play.getY()+57,55,55);
            }
            return;
        }
    }
    public void elephantRule(ChessmanBehavior play, ChessmanBehavior playQ[], MouseEvent me, List<ChessRegret> chessRegretList,int man){
        int ex=me.getX();
        int ey=me.getY()+30;
        int move=0;
        //上界河
        if(play.getY()<=284){
            if(ey>=341) return;
        }
        if(play.getY()>=341){
            if(ey<341) return;
        }
        System.out.println("鼠标"+ex+" "+ey);
        System.out.println("棋"+play.getX()+" "+play.getY());
        //左上
        if(play.getX()-ex<=114&&play.getX()-ex>57&&play.getY()-ey<=114&&play.getY()-ey>57){
            for (int i = 0; i < 32; i++) {
                if(playQ[i].died==false&&playQ[i].getX()==play.getX()-57&&playQ[i].getY()==play.getY()-57){
                    move=1;
                    break;
                }
            }
            if (move==0) {
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx=play.getX();
                chessRegret.cy= play.getY();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX()-114,play.getY()-114,55,55);
            }
        }
        //右上
        if(ex-play.getX()<=171&&ex-play.getX()>114&&play.getY()-ey<=114&&play.getY()-ey>57){
            for (int i = 0; i < 32; i++) {
                if(playQ[i].died==false&&playQ[i].getX()==play.getX()+57&&playQ[i].getY()==play.getY()-57){
                    move=1;
                    break;
                }
            }
            if (move==0) {
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx=play.getX();
                chessRegret.cy= play.getY();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX()+114,play.getY()-114,55,55);
            }
        }
        //左下
        if(play.getX()-ex<=114&&play.getX()-ex>57&&ey-play.getY()-30<=114&&ey-play.getY()-30>57){
            for (int i = 0; i < 32; i++) {
                if(playQ[i].died==false&&playQ[i].getX()==play.getX()-57&&playQ[i].getY()==play.getY()+57){
                    move=1;
                    break;
                }
            }
            if (move==0) {
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx=play.getX();
                chessRegret.cy= play.getY();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX()-114,play.getY()+114,55,55);
            }
        }
        //右下
        if(ex-play.getX()<=171&&ex-play.getX()>114&&ey-play.getY()-30<=114&&ey-play.getY()-30>57){
            for (int i = 0; i < 32; i++) {
                if(playQ[i].died==false&&playQ[i].getX()==play.getX()+57&&playQ[i].getY()==play.getY()+57){
                    move=1;
                    break;
                }
            }
            if (move==0) {
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx=play.getX();
                chessRegret.cy= play.getY();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX()+114,play.getY()+114,55,55);
            }
        }
    }
    public void chapRule(ChessmanBehavior play, ChessmanBehavior playQ[], MouseEvent me, List<ChessRegret> chessRegretList,int man){
        int judge=play.getName().charAt(1)-'0';//判断棋手
        int ex=me.getX();
        int ey=me.getY();
        //右上
        System.out.println("鼠标"+ex+" "+ey);
        System.out.println("棋"+play.getX()+" "+play.getY());
        if(ex-play.getX()>57&&ex-play.getX()<=114&&play.getY()-ey>0&&play.getY()-ey<=57){
            if (judge == 1 && play.getX() + 57 >= 252 && play.getX() + 57 <= 309) {
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx=play.getX();
                chessRegret.cy=play.getY();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX()+57,play.getY()-57,55,55);
                return;
            }
            if(judge==2&&play.getY()-57<=512&&play.getY()-57>=455&&play.getX()+57>=252&&play.getX()+57<=309){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx=play.getX();
                chessRegret.cy=play.getY();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX()+57,play.getY()-57,55,55);
                return;
            }
        }
        //右下
        if(ex-play.getX()>57&&ex-play.getX()<=114&&ey-play.getY()>0&&ey-play.getY()<=57){
            if (judge == 1 && play.getX() + 57 >= 252 && play.getX() + 57 <= 309) {
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx=play.getX();
                chessRegret.cy=play.getY();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX()+57,play.getY()+57,55,55);
                return;
            }
            if(judge==2&&play.getY()+57<=569&&play.getY()+57>=512&&play.getX()+57>=252&&play.getX()+57<=309){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx=play.getX();
                chessRegret.cy=play.getY();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX()+57,play.getY()+57,55,55);
                return;
            }
        }
        //左上
        if(play.getX()-ex>0&&play.getX()-ex<=57&&play.getY()-ey>0&&play.getY()-ey<=57){
            if (judge == 1 && play.getX() - 57 >= 195 && play.getX() - 57 <= 252) {
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx=play.getX();
                chessRegret.cy=play.getY();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX()-57,play.getY()-57,55,55);
                return;
            }
            if(judge==2&&play.getY()-57>=455&&play.getX()-57>=195&&play.getX()-57<=252){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx=play.getX();
                chessRegret.cy=play.getY();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX()-57,play.getY()-57,55,55);
                return;
            }
        }
        //左下
        if(play.getX()-ex>0&&play.getX()-ex<=57&&ey-play.getY()>0&&ey-play.getY()<=57){
            if (judge == 1 && play.getX() - 57 >= 195 && play.getX() - 57 <= 252) {
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx=play.getX();
                chessRegret.cy=play.getY();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX()-57,play.getY()+57,55,55);
                return;
            }
            if(judge==2&&play.getY()+57<=569&&play.getX()-57>=195&&play.getX()-57<=252){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx=play.getX();
                chessRegret.cy=play.getY();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX()-57,play.getY()+57,55,55);
                return;
            }
        }
    }
    public void masterRule(ChessmanBehavior play, ChessmanBehavior playQ[], MouseEvent me, List<ChessRegret> chessRegretList,int man){
        int ex=me.getX();
        int ey= me.getY();
        int judge=play.getName().charAt(1)-'0';
        //向上移动
        System.out.println("鼠标"+ex+" "+ey);
        System.out.println("棋"+play.getX()+" "+play.getY());
        if(ex-play.getX()>=0&&ex-play.getX()<57&&play.getY()-ey>0&&play.getY()-ey<=57){
            if(judge==1&&(play.getX()==195||play.getX()==252||play.getX()==309)&&(play.getY()==113||play.getY()==170)){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx=play.getX();
                chessRegret.cy=play.getY();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX(),play.getY()-57,55,55);
                return;
            }
            if(judge==2&&(play.getX()==195||play.getX()==252||play.getX()==309)&&(play.getY()==512||play.getY()==569)){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx=play.getX();
                chessRegret.cy=play.getY();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX(),play.getY()-57,55,55);
                return;
            }
        }
        //向下
        if(ex-play.getX()>=0&&ex-play.getX()<57&&ey-play.getY()>0&&ey-play.getY()<56){
            if(judge==1&&(play.getX()==195||play.getX()==252||play.getX()==309)&&(play.getY()==113||play.getY()==56)){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx=play.getX();
                chessRegret.cy=play.getY();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX(),play.getY()+57,55,55);
                return;
            }
            if(judge==2&&(play.getX()==195||play.getX()==252||play.getX()==309)&&(play.getY()==512||play.getY()==455)){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx=play.getX();
                chessRegret.cy=play.getY();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX(),play.getY()+57,55,55);
                return;
            }
        }
        //向左
        if(play.getX()-ex>0&&play.getX()-ex<=57&&ey-play.getY()>=-28&&ey-play.getY()<56){
            if(judge==1&&(play.getX()==252||play.getX()==309)&&(play.getY()==113||play.getY()==170||play.getY()==56)){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx=play.getX();
                chessRegret.cy=play.getY();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX()-57,play.getY(),55,55);
                return;
            }
            if(judge==2&&(play.getX()==252||play.getX()==309)&&(play.getY()==455||play.getY()==512||play.getY()==569)){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx=play.getX();
                chessRegret.cy=play.getY();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX()-57,play.getY(),55,55);
                return;
            }
        }
        //向右
        if(ex-play.getX()>57&&ex-play.getX()<=114&&ey-play.getY()>=-28&&ey-play.getY()<57){
            if(judge==1&&(play.getX()==252||play.getX()==195)&&(play.getY()==113||play.getY()==170||play.getY()==56)){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx=play.getX();
                chessRegret.cy=play.getY();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX()+57,play.getY(),55,55);
                return;
            }
            if(judge==2&&(play.getX()==252||play.getX()==195)&&(play.getY()==455||play.getY()==512||play.getY()==569)){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx=play.getX();
                chessRegret.cy=play.getY();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX()+57,play.getY(),55,55);
                return;
            }
        }
    }
    public void soliderRule(ChessmanBehavior play, ChessmanBehavior playQ[], MouseEvent me, List<ChessRegret> chessRegretList,int man){
        int judge=play.getName().charAt(1)-'0';
        int ex=me.getX();
        int ey=me.getY()+30;
        //黑棋
//        System.out.println("鼠标"+ex+" "+ey);
//        System.out.println("棋"+play.getX()+" "+play.getY());
        if(judge==1){
            if(ex-play.getX()>=0&&ex-play.getX()<57&&ey-play.getY()>57&&ey-play.getY()<114){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cy=play.getY();
                chessRegret.cx= play.getX();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX(),play.getY()+57,55,55);
                return;
            }
            //过河后,向右
            if(play.getY()>=341&&ey-play.getY()>=0&&ey-play.getY()<57&&ex-play.getX()>=57&&ex-play.getX()<114){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cy=play.getY();
                chessRegret.cx= play.getX();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX()+57,play.getY(),55,55);
                return;
            }
            //过河后，向左
            if(play.getY()>=341&&ey-play.getY()>=0&&ey-play.getY()<57&&play.getX()-ex>0&&play.getX()-ex<=57){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cy=play.getY();
                chessRegret.cx= play.getX();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX()-57,play.getY(),55,55);
                return;
            }
        }
        //红棋
        if(judge==2){
            if(ex-play.getX()>=0&&ex-play.getX()<57&&play.getY()-ey>0&&play.getY()-ey<=57){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cy=play.getY();
                chessRegret.cx= play.getX();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX(),play.getY()-57,55,55);
                return;
            }
            //过河后,向右
            if(play.getY()<=284&&ey-play.getY()>=0&&ey-play.getY()<57&&ex-play.getX()>=57&&ex-play.getX()<114){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cy=play.getY();
                chessRegret.cx= play.getX();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX()+57,play.getY(),55,55);
                return;
            }
            //过河后，向左
            if(play.getY()<=284&&ey-play.getY()>=0&&ey-play.getY()<57&&play.getX()-ex>0&&play.getX()-ex<=57){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cy=play.getY();
                chessRegret.cx= play.getX();
                chessRegretList.add(chessRegret);
                play.playSoundDown();
                play.setBounds(play.getX()-57,play.getY(),55,55);
                return;
            }
        }
    }
    //吃棋规则
    //play操作的棋子 playQ:包含32个棋子的数组 enemy:被吃的棋 me:鼠标点击对象 chessRegretList:操作记录,用于悔棋 man:操作对象判断鼠标点击棋子对象  beEat:被吃棋的下标
    public void carEat(ChessmanBehavior play,ChessmanBehavior playQ[],ChessmanBehavior enemy,List<ChessRegret> chessRegretList,int man,int beEat){
        int count=0;
        //上下吃
        if(play.getX()==enemy.getX()){
            for (int i = 0; i < 32; i++) {
                //向下吃
                if(play.getY()<enemy.getY()){
                    for (int j=play.getY()+57;j<enemy.getY();j+=57){
                        if(playQ[i].getX()==play.getX()&&playQ[i].getY()==j&&playQ[i].died==false){
                            count++;
                        }
                    }
                }else{
                    for (int j = enemy.getY()+57; j <play.getY() ; j+=57) {
                        if(playQ[i].getX()==play.getX()&&playQ[i].getY()==j&&playQ[i].died==false){
                            count++;
                        }
                    }
                }
            }
            if(count==0){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.eatMan=beEat;
                chessRegret.cx=play.getX();
                chessRegret.cy= play.getY();
                chessRegret.man=man;
                play.playSoundEat();
                chessRegretList.add(chessRegret);
                enemy.setVisible(false);//?
                enemy.died=true;
                play.setBounds(enemy.getX(),enemy.getY(),55,55);
                return;
            }
        }
        //左右吃
        if(play.getY()==enemy.getY()){
            for (int i = 0; i < 32; i++) {
                //向下吃
                if(play.getX()<enemy.getX()){
                    for (int j=play.getX()+57;j<enemy.getX();j+=57){
                        if(playQ[i].getY()==play.getY()&&playQ[i].getX()==j&&playQ[i].died==false){
                            count++;
                        }
                    }
                }else{
                    for (int j = enemy.getX()+57; j <play.getX() ; j+=57) {
                        if(playQ[i].getY()==play.getY()&&playQ[i].getX()==j&&playQ[i].died==false){
                            count++;
                        }
                    }
                }
            }
            if(count==0){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.eatMan=beEat;
                chessRegret.cx=play.getX();
                chessRegret.cy= play.getY();
                chessRegret.man=man;
                play.playSoundEat();
                chessRegretList.add(chessRegret);
                enemy.setVisible(false);//?
                enemy.died=true;
                play.setBounds(enemy.getX(),enemy.getY(),55,55);
                return;
            }
        }
    }
    public void cannonEat(ChessmanBehavior play,ChessmanBehavior playQ[],ChessmanBehavior enemy,List<ChessRegret> chessRegretList,int man,int beEat){
        int count=0;
        //上下吃
        if(play.getX()==enemy.getX()){
            for (int i = 0; i < 32; i++) {
                //向下吃
                if(play.getY()<enemy.getY()){
                    for (int j=play.getY()+57;j<enemy.getY();j+=57){
                        if(playQ[i].getX()==play.getX()&&playQ[i].getY()==j&&playQ[i].died==false){
                            count++;
                        }
                    }
                }else{
                    for (int j = enemy.getY()+57; j <play.getY() ; j+=57) {
                        if(playQ[i].getX()==play.getX()&&playQ[i].getY()==j&&playQ[i].died==false){
                            count++;
                        }
                    }
                }
            }
            if(count==1){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.eatMan=beEat;
                chessRegret.cx=play.getX();
                chessRegret.cy= play.getY();
                chessRegret.man=man;
                play.playSoundEat();
                chessRegretList.add(chessRegret);
                enemy.setVisible(false);//?
                enemy.died=true;
                play.setBounds(enemy.getX(),enemy.getY(),55,55);
                return;
            }
        }
        //左右吃
        if(play.getY()==enemy.getY()){
            for (int i = 0; i < 32; i++) {
                //向下吃
                if(play.getX()<enemy.getX()){
                    for (int j=play.getX()+57;j<enemy.getX();j+=57){
                        if(playQ[i].getY()==play.getY()&&playQ[i].getX()==j&&playQ[i].died==false){
                            count++;
                        }
                    }
                }else{
                    for (int j = enemy.getX()+57; j <play.getX() ; j+=57) {
                        if(playQ[i].getY()==play.getY()&&playQ[i].getX()==j&&playQ[i].died==false){
                            count++;
                        }
                    }
                }
            }
            if(count==1){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.eatMan=beEat;
                chessRegret.cx=play.getX();
                chessRegret.cy= play.getY();
                chessRegret.man=man;
                play.playSoundEat();
                chessRegretList.add(chessRegret);
                enemy.setVisible(false);//?
                enemy.died=true;
                play.setBounds(enemy.getX(),enemy.getY(),55,55);
                return;
            }
        }
    }
    public void horseEat(ChessmanBehavior play,ChessmanBehavior playQ[],ChessmanBehavior enemy,List<ChessRegret> chessRegretList,int man,int beEat){
        int canGo=1;
        //左右上
        if(play.getX()-57==enemy.getX()||play.getX()+57==enemy.getX()&&play.getY()-114==enemy.getY()){
            //判读撇腿
            for (int i = 0; i < 32; i++) {
                if(playQ[i].getX()==play.getX()&&playQ[i].getY()-57==play.getY()){
                    canGo=0;
                }
            }
            if(canGo==1){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cy=enemy.getY();
                chessRegret.cx=enemy.getX();
                chessRegret.eatMan=beEat;
                play.playSoundEat();
                chessRegretList.add(chessRegret);
                enemy.setVisible(false);
                enemy.died=true;
                play.setBounds(enemy.getX(),enemy.getY(),55,55);
                return;
            }
        }
        //左右下
        if(play.getX()-57==enemy.getX()||play.getX()+57==enemy.getX()&&play.getY()+114==enemy.getY()){
            //判读撇腿
            for (int i = 0; i < 32; i++) {
                if(playQ[i].getX()==play.getX()&&playQ[i].getY()-57==play.getY()){
                    canGo=0;
                }
            }
            if(canGo==1){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cy=enemy.getY();
                chessRegret.cx=enemy.getX();
                chessRegret.eatMan=beEat;
                play.playSoundEat();
                chessRegretList.add(chessRegret);
                enemy.setVisible(false);
                enemy.died=true;
                play.setBounds(enemy.getX(),enemy.getY(),55,55);
                return;
            }
        }
        //上下左
        if(play.getY()-57==enemy.getY()||play.getY()+57==enemy.getY()&&play.getX()-114==enemy.getX()){
            //判读撇腿
            for (int i = 0; i < 32; i++) {
                if(playQ[i].getY()==play.getY()&&playQ[i].getX()+57==play.getX()){
                    canGo=0;
                }
            }
            if(canGo==1){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cy=enemy.getY();
                chessRegret.cx=enemy.getX();
                chessRegret.eatMan=beEat;
                play.playSoundEat();
                chessRegretList.add(chessRegret);
                enemy.setVisible(false);
                enemy.died=true;
                play.setBounds(enemy.getX(),enemy.getY(),55,55);
                return;
            }
        }
        //上下右
        if(play.getY()-57==enemy.getY()||play.getY()+57==enemy.getY()&&play.getX()+114==enemy.getX()){
            //判读撇腿
            for (int i = 0; i < 32; i++) {
                if(playQ[i].getY()==play.getY()&&playQ[i].getX()-57==play.getX()){
                    canGo=0;
                }
            }
            if(canGo==1){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cy=enemy.getY();
                chessRegret.cx=enemy.getX();
                chessRegret.eatMan=beEat;
                play.playSoundEat();
                chessRegretList.add(chessRegret);
                enemy.setVisible(false);
                enemy.died=true;
                play.setBounds(enemy.getX(),enemy.getY(),55,55);
                return;
            }
        }
    }
    public void elephantEat(ChessmanBehavior play,ChessmanBehavior playQ[],ChessmanBehavior enemy,List<ChessRegret> chessRegretList,int man,int beEat){
        int canGo=1;
        int judge=play.getName().charAt(1)-'0';
        //左上
        if(play.getX()-114==enemy.getX()&&play.getY()-114==enemy.getY()){
            if((judge==1&&enemy.getY()<=284)||(judge==2&&enemy.getY()>=341)){
                for (int i = 0; i < 32; i++) {
                    if(play.getY()-57==playQ[i].getY()&&play.getX()-57==playQ[i].getX()&&playQ[i].died==false){
                        canGo=0;
                    }
                }
                if(canGo==1){
                    ChessRegret chessRegret=new ChessRegret();
                    chessRegret.man=man;
                    chessRegret.cx= play.getX();
                    chessRegret.cy= play.getY();
                    chessRegret.eatMan=beEat;
                    play.playSoundEat();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died=true;
                    play.setBounds(enemy.getX(),enemy.getY(),55,55);
                    return;
                }
            }
        }
        //右上
        if(play.getX()+114==enemy.getX()&&play.getY()-114==enemy.getY()){
            if((judge==1&&enemy.getY()<=284)||(judge==2&&enemy.getY()>=341)){
                for (int i = 0; i < 32; i++) {
                    if(play.getY()-57==playQ[i].getY()&&play.getX()+57==playQ[i].getX()&&playQ[i].died==false){
                        canGo=0;
                    }
                }
                if(canGo==1){
                    ChessRegret chessRegret=new ChessRegret();
                    chessRegret.man=man;
                    chessRegret.cx= play.getX();
                    chessRegret.cy= play.getY();
                    chessRegret.eatMan=beEat;
                    play.playSoundEat();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died=true;
                    play.setBounds(enemy.getX(),enemy.getY(),55,55);
                    return;
                }
            }
        }
        //左下
        if(play.getX()-114==enemy.getX()&&play.getY()+114==enemy.getY()){
            if((judge==1&&enemy.getY()<=284)||(judge==2&&enemy.getY()>=341)){
                for (int i = 0; i < 32; i++) {
                    if(play.getY()+57==playQ[i].getY()&&play.getX()-57==playQ[i].getX()&&playQ[i].died==false){
                        canGo=0;
                    }
                }
                if(canGo==1){
                    ChessRegret chessRegret=new ChessRegret();
                    chessRegret.man=man;
                    chessRegret.cx= play.getX();
                    chessRegret.cy= play.getY();
                    chessRegret.eatMan=beEat;
                    play.playSoundEat();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died=true;
                    play.setBounds(enemy.getX(),enemy.getY(),55,55);
                    return;
                }
            }
        }
        //右下
        if(play.getX()+114==enemy.getX()&&play.getY()+114==enemy.getY()){
            if((judge==1&&enemy.getY()<=284)||(judge==2&&enemy.getY()>=341)){
                for (int i = 0; i < 32; i++) {
                    if(play.getY()+57==playQ[i].getY()&&play.getX()+57==playQ[i].getX()&&playQ[i].died==false){
                        canGo=0;
                    }
                }
                if(canGo==1){
                    ChessRegret chessRegret=new ChessRegret();
                    chessRegret.man=man;
                    chessRegret.cx= play.getX();
                    chessRegret.cy= play.getY();
                    chessRegret.eatMan=beEat;
                    play.playSoundEat();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died=true;
                    play.setBounds(enemy.getX(),enemy.getY(),55,55);
                    return;
                }
            }
        }
    }
    public void chapEat(ChessmanBehavior play,ChessmanBehavior playQ[],ChessmanBehavior enemy,List<ChessRegret> chessRegretList,int man,int beEat){
        int judge=play.getName().charAt(1)-'0';
        //左上
        if(enemy.getX()==play.getX()-57&&enemy.getY()==play.getY()-57){
            if(judge==1){
                if((enemy.getX()==252&&enemy.getY()==113)||(enemy.getX()==192&&enemy.getY()==56)){
                    ChessRegret chessRegret=new ChessRegret();
                    chessRegret.man=man;
                    chessRegret.cx=play.getX();
                    chessRegret.cy=play.getY();
                    chessRegret.eatMan=beEat;
                    play.playSoundEat();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died=true;
                    play.setBounds(enemy.getX(),enemy.getY(),55,55);
                    return;
                }
            }
            if(judge==2){
                if((enemy.getX()==252&&enemy.getY()==512)||(enemy.getX()==195&&enemy.getY()==455)){
                    ChessRegret chessRegret=new ChessRegret();
                    chessRegret.man=man;
                    chessRegret.cx=play.getX();
                    chessRegret.cy=play.getY();
                    chessRegret.eatMan=beEat;
                    play.playSoundEat();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died=true;
                    play.setBounds(enemy.getX(),enemy.getY(),55,55);
                    return;
                }
            }
        }
        //左下
        if(enemy.getX()==play.getX()-57&&enemy.getY()==play.getY()+57){
            if(judge==1){
                if((enemy.getX()==252&&enemy.getY()==113)||(enemy.getX()==195&&enemy.getY()==170)){
                    ChessRegret chessRegret=new ChessRegret();
                    chessRegret.man=man;
                    chessRegret.cx=play.getX();
                    chessRegret.cy=play.getY();
                    chessRegret.eatMan=beEat;
                    play.playSoundEat();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died=true;
                    play.setBounds(enemy.getX(),enemy.getY(),55,55);
                    return;
                }
            }
            if(judge==2){
                if((enemy.getX()==252&&enemy.getY()==512)||(enemy.getX()==195&&enemy.getY()==569)){
                    ChessRegret chessRegret=new ChessRegret();
                    chessRegret.man=man;
                    chessRegret.cx=play.getX();
                    chessRegret.cy=play.getY();
                    chessRegret.eatMan=beEat;
                    play.playSoundEat();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died=true;
                    play.setBounds(enemy.getX(),enemy.getY(),55,55);
                    return;
                }
            }
        }
        //右上
        if(enemy.getX()==play.getX()+57&&enemy.getY()==play.getY()-57){
            if(judge==1){
                if((enemy.getX()==252&&enemy.getY()==113)||(enemy.getX()==309&&enemy.getY()==56)){
                    ChessRegret chessRegret=new ChessRegret();
                    chessRegret.man=man;
                    chessRegret.cx=play.getX();
                    chessRegret.cy=play.getY();
                    chessRegret.eatMan=beEat;
                    play.playSoundEat();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died=true;
                    play.setBounds(enemy.getX(),enemy.getY(),55,55);
                    return;
                }
            }
            if(judge==2){
                if((enemy.getX()==252&&enemy.getY()==512)||(enemy.getX()==309&&enemy.getY()==455)){
                    ChessRegret chessRegret=new ChessRegret();
                    chessRegret.man=man;
                    chessRegret.cx=play.getX();
                    chessRegret.cy=play.getY();
                    chessRegret.eatMan=beEat;
                    play.playSoundEat();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died=true;
                    play.setBounds(enemy.getX(),enemy.getY(),55,55);
                    return;
                }
            }
        }
        //右下
        if(enemy.getX()==play.getX()+57&&enemy.getY()==play.getY()+57){
            if(judge==1){
                if((enemy.getX()==252&&enemy.getY()==113)||(enemy.getX()==309&&enemy.getY()==170)){
                    ChessRegret chessRegret=new ChessRegret();
                    chessRegret.man=man;
                    chessRegret.cx=play.getX();
                    chessRegret.cy=play.getY();
                    chessRegret.eatMan=beEat;
                    play.playSoundEat();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died=true;
                    play.setBounds(enemy.getX(),enemy.getY(),55,55);
                    return;
                }
            }
            if(judge==2){
                if((enemy.getX()==252&&enemy.getY()==512)||(enemy.getX()==309&&enemy.getY()==569)){
                    ChessRegret chessRegret=new ChessRegret();
                    chessRegret.man=man;
                    chessRegret.cx=play.getX();
                    chessRegret.cy=play.getY();
                    chessRegret.eatMan=beEat;
                    play.playSoundEat();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died=true;
                    play.setBounds(enemy.getX(),enemy.getY(),55,55);
                    return;
                }
            }
        }
    }
    public void masterEat(ChessmanBehavior play,ChessmanBehavior playQ[],ChessmanBehavior enemy,List<ChessRegret> chessRegretList,int man,int beEat){
        int judge=play.getName().charAt(1)-'0';
        //向上
        System.out.println("吃"+play.getX()+" "+play.getY());
        System.out.println(" 被吃"+enemy.getX()+" "+enemy.getY());

        if(enemy.getX()==play.getX()&&enemy.getY()==play.getY()-57){
            if(judge==1){
                if((enemy.getX()==195&&enemy.getY()==113)||(enemy.getX()==195&&enemy.getY()==56)||
                        (enemy.getX()==252&&enemy.getY()==113)||(enemy.getX()==252&&enemy.getY()==56)||
                        (enemy.getX()==309&&enemy.getY()==113)||(enemy.getX()==309&&enemy.getY()==56)){
                    ChessRegret chessRegret=new ChessRegret();
                    chessRegret.man=man;
                    chessRegret.cx=play.getX();
                    chessRegret.cy=play.getY();
                    chessRegret.eatMan=beEat;
                    play.playSoundEat();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died=true;
                    play.setBounds(enemy.getX(),enemy.getY(),55,55);
                    return;
                }
            }
            if(judge==2){
                if((enemy.getX()==195&&enemy.getY()==455)||(enemy.getX()==195&&enemy.getY()==512)||
                        (enemy.getX()==252&&enemy.getY()==455)||(enemy.getX()==252&&enemy.getY()==512)||
                        (enemy.getX()==309&&enemy.getY()==455)||(enemy.getX()==309&&enemy.getY()==512)){
                    ChessRegret chessRegret=new ChessRegret();
                    chessRegret.man=man;
                    chessRegret.cx=play.getX();
                    chessRegret.cy=play.getY();
                    chessRegret.eatMan=beEat;
                    play.playSoundEat();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died=true;
                    play.setBounds(enemy.getX(),enemy.getY(),55,55);
                    return;
                }
            }
        }
        //向下
        if(enemy.getX()==play.getX()&&enemy.getY()==play.getY()+57){
            if(judge==1){
                if((enemy.getX()==195&&enemy.getY()==113)||(enemy.getX()==195&&enemy.getY()==170)||
                        (enemy.getX()==252&&enemy.getY()==113)||(enemy.getX()==252&&enemy.getY()==170)||
                        (enemy.getX()==309&&enemy.getY()==113)||(enemy.getX()==309&&enemy.getY()==170)){
                    ChessRegret chessRegret=new ChessRegret();
                    chessRegret.man=man;
                    chessRegret.cx=play.getX();
                    chessRegret.cy=play.getY();
                    chessRegret.eatMan=beEat;
                    play.playSoundEat();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died=true;
                    play.setBounds(enemy.getX(),enemy.getY(),55,55);
                    return;
                }
            }
            if(judge==2){
                if((enemy.getX()==195&&enemy.getY()==569)||(enemy.getX()==195&&enemy.getY()==512)||
                        (enemy.getX()==252&&enemy.getY()==569)||(enemy.getX()==252&&enemy.getY()==512)||
                        (enemy.getX()==309&&enemy.getY()==569)||(enemy.getX()==309&&enemy.getY()==512)){
                    ChessRegret chessRegret=new ChessRegret();
                    chessRegret.man=man;
                    chessRegret.cx=play.getX();
                    chessRegret.cy=play.getY();
                    chessRegret.eatMan=beEat;
                    play.playSoundEat();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died=true;
                    play.setBounds(enemy.getX(),enemy.getY(),55,55);
                    return;
                }
            }
        }
        //向左
        if(enemy.getX()==play.getX()-57&&enemy.getY()==play.getY()){
            if(judge==1){
                if((enemy.getX()==195&&enemy.getY()==113)||(enemy.getX()==195&&enemy.getY()==170)||
                        (enemy.getX()==252&&enemy.getY()==113)||(enemy.getX()==252&&enemy.getY()==170)||
                        (enemy.getX()==195&&enemy.getY()==56)||(enemy.getX()==252&&enemy.getY()==56)){
                    ChessRegret chessRegret=new ChessRegret();
                    chessRegret.man=man;
                    chessRegret.cx=play.getX();
                    chessRegret.cy=play.getY();
                    chessRegret.eatMan=beEat;
                    play.playSoundEat();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died=true;
                    play.setBounds(enemy.getX(),enemy.getY(),55,55);
                    return;
                }
            }
            if(judge==2){
                if((enemy.getX()==195&&enemy.getY()==569)||(enemy.getX()==195&&enemy.getY()==512)||
                        (enemy.getX()==252&&enemy.getY()==569)||(enemy.getX()==252&&enemy.getY()==512)||
                        (enemy.getX()==195&&enemy.getY()==455)||(enemy.getX()==252&&enemy.getY()==455)){
                    ChessRegret chessRegret=new ChessRegret();
                    chessRegret.man=man;
                    chessRegret.cx=play.getX();
                    chessRegret.cy=play.getY();
                    chessRegret.eatMan=beEat;
                    play.playSoundEat();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died=true;
                    play.setBounds(enemy.getX(),enemy.getY(),55,55);
                    return;
                }
            }
        }
        //向右
        if(enemy.getX()==play.getX()+57&&enemy.getY()==play.getY()){
            if(judge==1){
                if((enemy.getX()==309&&enemy.getY()==113)||(enemy.getX()==309&&enemy.getY()==170)||
                        (enemy.getX()==252&&enemy.getY()==113)||(enemy.getX()==252&&enemy.getY()==170)||
                        (enemy.getX()==309&&enemy.getY()==56)||(enemy.getX()==252&&enemy.getY()==56)){
                    ChessRegret chessRegret=new ChessRegret();
                    chessRegret.man=man;
                    chessRegret.cx=play.getX();
                    chessRegret.cy=play.getY();
                    chessRegret.eatMan=beEat;
                    play.playSoundEat();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died=true;
                    play.setBounds(enemy.getX(),enemy.getY(),55,55);
                    return;
                }
            }
            if(judge==2){
                if((enemy.getX()==309&&enemy.getY()==569)||(enemy.getX()==309&&enemy.getY()==512)||
                        (enemy.getX()==252&&enemy.getY()==569)||(enemy.getX()==252&&enemy.getY()==512)||
                        (enemy.getX()==309&&enemy.getY()==455)||(enemy.getX()==252&&enemy.getY()==455)){
                    ChessRegret chessRegret=new ChessRegret();
                    chessRegret.man=man;
                    chessRegret.cx=play.getX();
                    chessRegret.cy=play.getY();
                    chessRegret.eatMan=beEat;
                    play.playSoundEat();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died=true;
                    play.setBounds(enemy.getX(),enemy.getY(),55,55);
                    return;
                }
            }
        }
    }
    public void solidEat(ChessmanBehavior play,ChessmanBehavior playQ[],ChessmanBehavior enemy,List<ChessRegret> chessRegretList,int man,int beEat){
        int judge=play.getName().charAt(1)-'0';
        //红向上
        if(play.getX()==enemy.getX()&&play.getY()-57==enemy.getY()){
            if(judge==2){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx=play.getX();
                chessRegret.cy=play.getY();
                chessRegret.eatMan=beEat;
                play.playSoundEat();
                chessRegretList.add(chessRegret);
                enemy.setVisible(false);
                enemy.died=true;
                play.setBounds(enemy.getX(),enemy.getY(),55,55);
                return;
            }
        }
        //黑向下吃
        if(play.getX()==enemy.getX()&&play.getY()+57==enemy.getY()){
            if(judge==1){
                ChessRegret chessRegret=new ChessRegret();
                chessRegret.man=man;
                chessRegret.cx=play.getX();
                chessRegret.cy=play.getY();
                chessRegret.eatMan=beEat;
                play.playSoundEat();
                chessRegretList.add(chessRegret);
                enemy.setVisible(false);
                enemy.died=true;
                play.setBounds(enemy.getX(),enemy.getY(),55,55);
                return;
            }
        }
        //向左吃
        if(play.getX()-57==enemy.getX()&&play.getY()==enemy.getY()){
            if(judge==1) {
                //过河界
                if (enemy.getY() >= 341) {
                    ChessRegret chessRegret = new ChessRegret();
                    chessRegret.man = man;
                    chessRegret.cx = play.getX();
                    chessRegret.cy = play.getY();
                    chessRegret.eatMan = beEat;
                    play.playSoundEat();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died = true;
                    play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                    return;
                }
            }
            if(judge==2){
                if(enemy.getY()<341){
                    ChessRegret chessRegret = new ChessRegret();
                    chessRegret.man = man;
                    chessRegret.cx = play.getX();
                    chessRegret.cy = play.getY();
                    chessRegret.eatMan = beEat;
                    play.playSoundEat();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died = true;
                    play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                    return;
                }
            }
        }
        //向右
        if(play.getX()+57==enemy.getX()&&play.getY()==enemy.getY()){
            if(judge==1) {
                //过河界
                if (enemy.getY() >= 341) {
                    ChessRegret chessRegret = new ChessRegret();
                    chessRegret.man = man;
                    chessRegret.cx = play.getX();
                    chessRegret.cy = play.getY();
                    chessRegret.eatMan = beEat;
                    play.playSoundEat();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died = true;
                    play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                    return;
                }
            }
            if(judge==2){
                if(enemy.getY()<341){
                    ChessRegret chessRegret = new ChessRegret();
                    chessRegret.man = man;
                    chessRegret.cx = play.getX();
                    chessRegret.cy = play.getY();
                    chessRegret.eatMan = beEat;
                    play.playSoundEat();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died = true;
                    play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                    return;
                }
            }
        }
    }
    public int masterMeet(ChessmanBehavior playQ[]){
        if(playQ[30].getX()!=playQ[31].getX()) return 0;
        int count=0;
        int cx=playQ[30].getX();
        for (int i = playQ[30].getY(); i <playQ[31].getY() ; i+=57) {
            for (int j = 0; j < 30; j++) {
                if(playQ[j].getX()==cx&&playQ[j].getY()==i&&playQ[j].died==false){//boss之间是否存在棋子
                    count++;
                }
            }
        }
        if(count>0)
            return 0;
        return 1;
    }
}
