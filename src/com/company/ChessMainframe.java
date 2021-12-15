package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class ChessMainframe extends JFrame implements ActionListener, MouseListener,Runnable {
    ChessmanBehavior play[]=new ChessmanBehavior[32];
    JLabel image;//图片
    Container con;//容器
    JToolBar jmain;//工具栏
    JButton anew,repent,exit;//按钮
    JLabel text;//文字
    int chessPlayClick=2;//棋子状态1黑，2红，3都不动
    boolean chessManClick;//点击棋子的判断
    Thread tmain;//调用线程类
    static int Man;//棋子
    boolean gameIsOver;//判断游戏结束
    ChessRule chessRule;//规则类
    List<ChessRegret> regretList;
    //象棋的布局
    public ChessMainframe(String title){
        con=this.getContentPane();//布局图层
        con.setLayout(null);//固定容器位置
        this.setTitle(title);//设置窗口名字
        jmain=new JToolBar();//实例化工具栏
        text=new JLabel("欢迎使用象棋对弈系统");
        text.setToolTipText("信息提醒");
        anew=new JButton("新游戏");//定义按钮
        anew.setToolTipText("重新开始一局");
        repent=new JButton("悔棋");//定义按钮
        repent.setToolTipText("返回上次走棋位置");
        exit=new JButton("退出");//定义按钮
        exit.setToolTipText("退出系统");
        jmain.setLayout(new GridLayout(0,4));//工具栏定义四个
        jmain.add(anew);//添加按钮
        jmain.add(repent);//添加按钮
        jmain.add(exit);//添加按钮
        jmain.add(text);//添加按钮
        jmain.setBounds(0,0,558,30);//定义工具栏的大小位置
        con.add(jmain);//向容器中加入工具栏
        drawChessMain();
        for (int i = 0; i < 32; i++) {
            con.add(play[i]);//向容器中加入棋子
            play[i].addMouseListener(this);//加入鼠标的显示
        }
        con.add(image=new JLabel(new ImageIcon("image/main.gif")));
        image.setBounds(0,30,558,620);//创建按钮的位置
        image.addMouseListener(this);
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screenSize.width/2-280,screenSize.height/2-350);
        this.setIconImage(new ImageIcon("image/黑将.gft").getImage());//图标
        this.setResizable(false);//不可改变窗口大小
        this.setSize(558,676);//设置长宽
        this.setVisible(true);//可见
        gameIsOver=false;
        regretList=new ArrayList<ChessRegret>();//实例悔棋类
        chessRule=new ChessRule();//实例规则类
        this.addWindowListener(new WindowAdapter() {//定义按钮的实例
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);//退出
            }
        });
        anew.addActionListener(this);
        repent.addActionListener(this);
        exit.addActionListener(this);
    }
    //棋子的刷新
    public void chessReset(){
        int i,k;
        for (i = 0,k=24; i <2 ; i++,k+=456) {

            play[i].setBounds(k,56,55,55);

        }

        for (i = 4,k=81; i <6 ; i++,k+=342) {

            play[i].setBounds(k,56,55,55);

        }

        for (i = 8,k=138; i <10 ; i++,k+=228) {

            play[i].setBounds(k,56,55,55);

        }

        for (i = 12,k=195; i <14 ; i++,k+=114) {

            play[i].setBounds(k,56,55,55);

        }

        for (i = 16,k=24; i <21 ; i++,k+=114) {

            play[i].setBounds(k, 227, 55, 55);

        }

        for (i = 26,k=81; i <28 ; i++,k+=342) {
            play[i].setBounds(k,170,55,55);
        }
        play[30].setBounds(252,56,55,55);
        for (i = 2,k=24; i <4 ; i++,k+=456) {
            play[i].setBounds(k,569,55,55);
        }
        for (i = 6,k=81; i <8 ; i++,k+=342) {
            play[i].setBounds(k,569,55,55);
        }
        for (i = 10,k=138; i <12 ; i++,k+=228) {
            play[i].setBounds(k,569,55,55);
        }
        for (i = 14,k=195; i <16 ; i++,k+=114) {
            play[i].setBounds(k,569,55,55);
        }
        for (i = 21,k=24; i <26 ; i++,k+=114) {
            play[i].setBounds(k, 398, 55, 55);
        }
        for (i = 28,k=81; i <30 ; i++,k+=342) {
            play[i].setBounds(k,455,55,55);
        }
        play[31].setBounds(252,569,55,55);
        gameIsOver=false;
        for (int j = 0; j < 32; j++) {
            System.out.println(i+" "+play[j].getName());
            play[j].setVisible(true);
            play[j].died=false;
        }
        text.setText("   红走");
        chessPlayClick=2;
        Man=0;
        regretList.clear();//清空悔棋的list

    }
    //棋子位置的初始化
    public void drawChessMain(){
        int i,k;
        Icon in=null;//棋子
        in=new ImageIcon("image/黑车.gif");
        for (i = 0,k=24; i <2 ; i++,k+=456) {
            play[i]=new ChessmanBehavior(in);//添加棋子
            play[i].setBounds(k,56,55,55);
            play[i].setName("车1");
        }
        in=new ImageIcon("image/黑马.gif");
        for (i = 4,k=81; i <6 ; i++,k+=342) {
            play[i]=new ChessmanBehavior(in);//添加棋子
            play[i].setBounds(k,56,55,55);
            play[i].setName("马1");
        }
        in=new ImageIcon("image/黑象.gif");
        for (i = 8,k=138; i <10 ; i++,k+=228) {
            play[i]=new ChessmanBehavior(in);//添加棋子
            play[i].setBounds(k,56,55,55);
            play[i].setName("象1");
        }
        in=new ImageIcon("image/黑士.gif");
        for (i = 12,k=195; i <14 ; i++,k+=114) {
            play[i]=new ChessmanBehavior(in);//添加棋子
            play[i].setBounds(k,56,55,55);
            play[i].setName("士1");
        }
        in=new ImageIcon("image/黑卒.gif");
        for (i = 16,k=24; i <21 ; i++,k+=114) {
            play[i] = new ChessmanBehavior(in);//添加棋子
            play[i].setBounds(k, 227, 55, 55);
            play[i].setName("卒1");
        }
            in=new ImageIcon("image/黑炮.gif");
            for (i = 26,k=81; i <28 ; i++,k+=342) {
                play[i]=new ChessmanBehavior(in);//添加棋子
                play[i].setBounds(k,170,55,55);
                play[i].setName("炮1");
            }
            in=new ImageIcon("image/黑将.gif");
                play[30]=new ChessmanBehavior(in);//添加棋子
                play[30].setBounds(252,56,55,55);
                play[30].setName("将1");
            in=new ImageIcon("image/红车.gif");
            for (i = 2,k=24; i <4 ; i++,k+=456) {
                play[i]=new ChessmanBehavior(in);//添加棋子
                play[i].setBounds(k,569,55,55);
                play[i].setName("车2");
            }
            in=new ImageIcon("image/红马.gif");
            for (i = 6,k=81; i <8 ; i++,k+=342) {
                play[i]=new ChessmanBehavior(in);//添加棋子
                play[i].setBounds(k,569,55,55);
                play[i].setName("马2");
            }
            in=new ImageIcon("image/红象.gif");
            for (i = 10,k=138; i <12 ; i++,k+=228) {
                play[i]=new ChessmanBehavior(in);//添加棋子
                play[i].setBounds(k,569,55,55);
                play[i].setName("象2");
            }
            in=new ImageIcon("image/红士.gif");
            for (i = 14,k=195; i <16 ; i++,k+=114) {
                play[i]=new ChessmanBehavior(in);//添加棋子
                play[i].setBounds(k,569,55,55);
                play[i].setName("士2");
            }
            in=new ImageIcon("image/红卒.gif");
            for (i = 21,k=24; i <26 ; i++,k+=114) {
                play[i] = new ChessmanBehavior(in);//添加棋子
                play[i].setBounds(k, 398, 55, 55);
                play[i].setName("卒2");
            }
                in=new ImageIcon("image/红炮.gif");
                for (i = 28,k=81; i <30 ; i++,k+=342) {
                    play[i]=new ChessmanBehavior(in);//添加棋子
                    play[i].setBounds(k,455,55,55);
                    play[i].setName("炮2");
                }
                in=new ImageIcon("image/红将.gif");
                play[31]=new ChessmanBehavior(in);//添加棋子
                play[31].setBounds(252,569,55,55);
                play[31].setName("帅2");

            }
    //工具栏按钮
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(anew)){
            chessReset();
        }//重置
        if(e.getSource().equals(repent)){//悔棋
            if(regretList.isEmpty()==false){
                ChessRegret chessRegret=regretList.get(regretList.size()-1);
                Man=chessRegret.man;
                play[Man].setBounds(chessRegret.cx,chessRegret.cy,55,55);
                if(chessRegret.eatMan!=-1){
                    play[chessRegret.eatMan].setVisible(true);//重置被吃的棋
                    play[chessRegret.eatMan].died=false;
                }
                if(play[Man].getName().charAt(1)=='2'){
                    chessPlayClick=2;
                    text.setText(  "  红旗走");
                }else{
                    chessPlayClick=1;
                    text.setText(  "  黑旗走");
                }
                regretList.remove(regretList.size()-1);
            }
            return;
        }
        //退出
        if(e.getSource().equals(exit)){
            int j=JOptionPane.showConfirmDialog(this,"确定退出","退出",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(j==JOptionPane.YES_OPTION){
                System.exit(0) ;
            }
        }
    }
    //棋子的移动和吃棋
    @Override
    public void mouseClicked(MouseEvent e) {
        int ex=0;//鼠标
        int ey=0;
        if(tmain==null){
            tmain=new Thread(this);
            tmain.start();
        }//当线程未开启，点击时线程开启
        if(gameIsOver) return;//游戏结束了判断
        if(e.getSource().equals(image)){//getSource返回点击的对象
            if(chessPlayClick==2&&play[Man].getName().charAt(1)=='2'){
                ex=play[Man].getX();
                ey=play[Man].getY();//点击棋子，返回棋子的坐标
               System.out.println(e.getX()+" "+e.getY());
                if (Man>=0&&Man<4){
                    System.out.println("移动红车");
                    chessRule.carRule(play[Man],play,e,regretList,Man );
                }
                if (Man>=4&&Man<8){
                    System.out.println("移动红马");
                    chessRule.horseRule(play[Man],play,e,regretList,Man );
                }
                if (Man>=8&&Man<12){
                    System.out.println("移动红象");
                    chessRule.elephantRule(play[Man],play,e,regretList,Man );
                }
                if (Man>=12&&Man<16){
                    System.out.println("移动红士");
                    chessRule.chapRule(play[Man],play,e,regretList,Man );
                }
                if (Man>=16&&Man<26){
                    System.out.println("移动红兵");
                    chessRule.soliderRule(play[Man],play,e,regretList,Man );
                }
                if (Man>=26&&Man<30){
                    System.out.println("移动红炮");
                    chessRule.cannonRule(play[Man],play,e,regretList,Man );
                }
                if (Man==30||Man==31){
                    System.out.println("移动红帅");
                    chessRule.masterRule(play[Man],play,e,regretList,Man );
                }
                if(ex==play[Man].getX()&&ey==play[Man].getY()){
                    text.setText("  红棋走");
                    chessPlayClick=2;
                }else {
                    if(chessRule.masterMeet(play)==1){
                        JOptionPane.showMessageDialog(this,"游戏结束黑棋胜");
                        gameIsOver=true;
                        return;
                    }
                    text.setText("   黑棋走");
                    chessPlayClick=1;
                    chessManClick=false;
                }
            }else if(chessPlayClick==1&&play[Man].getName().charAt(1)=='1') {
                ex = play[Man].getX();
                ey = play[Man].getY();//点击棋子，返回棋子的坐标
                System.out.println(e.getX()+" "+e.getY());
                if (Man >= 0 && Man < 4) {
                    System.out.println("移动黑车");
                    chessRule.carRule(play[Man], play, e, regretList, Man);
                }
                if (Man >= 4 && Man < 8) {
                    System.out.println("移动黑马");
                    chessRule.horseRule(play[Man], play, e, regretList, Man);
                }
                if (Man >= 8 && Man < 12) {
                    System.out.println("移动黑象");
                    chessRule.elephantRule(play[Man], play, e, regretList, Man);
                }
                if (Man >= 12 && Man < 16) {
                    System.out.println("移动黑士");
                    chessRule.chapRule(play[Man], play, e, regretList, Man);
                }
                if (Man >= 16 && Man < 26) {
                    System.out.println("移动黑兵");
                    chessRule.soliderRule(play[Man], play, e, regretList, Man);
                }
                if (Man >= 26 && Man < 30) {
                    System.out.println("移动黑炮");
                    chessRule.cannonRule(play[Man], play, e, regretList, Man);
                }
                if (Man == 30 || Man == 31) {
                    System.out.println("移动黑帅");
                    chessRule.masterRule(play[Man], play, e, regretList, Man);
                }
                if (ex == play[Man].getX() && ey == play[Man].getY()) {
                    text.setText("  黑棋走");
                    chessPlayClick = 1;
                }else {
                    if(chessRule.masterMeet(play)==1){
                        JOptionPane.showMessageDialog(this,"游戏结束红棋胜");
                        gameIsOver=true;
                        return;
                    }
                    text.setText("   红棋走");
                    chessPlayClick=2;
                    chessManClick=false;
                }
            }
        }//点击对象是棋盘
        else {//点击对象是棋子
            int iClick=0;//棋子下标
            for (int i = 0; i < 32; i++) {
                if(e.getSource().equals(play[i])){//点击是棋子
                    iClick=i;//棋子的下标
                    break;
                }
            }
            if(chessPlayClick==2){//点击是红棋时
                if(play[iClick].getName().charAt(1)=='2'){
                    Man=iClick;
                    chessManClick=true;
                    return;
                }
                int judge=play[Man].getName().charAt(1)-'0';
                if(play[iClick].getName().charAt(1)=='1'&&judge==2){
                    if (Man >= 0 && Man < 4) {
                        System.out.println("车吃");
                        chessRule.carEat(play[Man], play,play[iClick], regretList, Man,iClick);
                    }
                    if (Man >= 4 && Man < 8) {
                        System.out.println("马吃");
                        chessRule.horseEat(play[Man], play,play[iClick], regretList, Man,iClick);
                    }
                    if (Man >= 8 && Man < 12) {
                        System.out.println("象吃");
                        chessRule.elephantEat(play[Man], play,play[iClick], regretList, Man,iClick);
                    }
                    if (Man >= 12 && Man < 16) {
                        System.out.println("士吃");
                        chessRule.chapEat(play[Man], play,play[iClick], regretList, Man,iClick);
                    }
                    if (Man >= 16 && Man < 26) {
                        System.out.println("兵吃");
                        chessRule.solidEat(play[Man], play,play[iClick], regretList, Man,iClick);
                    }
                    if (Man >= 26 && Man < 30) {
                        System.out.println("炮吃");
                        chessRule.cannonEat(play[Man], play,play[iClick], regretList, Man,iClick);
                    }
                    if (Man == 30 || Man == 31) {
                        System.out.println("师吃");
                        chessRule.masterEat(play[Man], play,play[iClick], regretList, Man,iClick);
                    }
                    //吃子判断
                    if(play[iClick].getX()==play[Man].getX()&&play[iClick].getY()==play[Man].getY()){
                        //判断胜利
                        if(chessRule.masterMeet(play)==1){
                            JOptionPane.showMessageDialog(this,"黑棋胜利");
                            text.setText("游戏结束，黑棋胜");
                            chessManClick=false;
                            gameIsOver=true;
                            return;
                        }
                        if(play[30].isVisible()==false){//黑棋帅被吃
                            JOptionPane.showMessageDialog(this,"红棋胜利");
                            text.setText("游戏结束，红棋胜");
                            chessManClick=false;
                            gameIsOver=true;
                            return;
                        }
                        chessPlayClick=1;
                        text.setText("黑棋走");
                        chessManClick=false;
                    }
                }//吃子状态
            }
            else if(chessPlayClick==1){
                if(play[iClick].getName().charAt(1)=='1'){
                    Man=iClick;
                    chessManClick=true;
                    return;
                }
                int judge=play[Man].getName().charAt(1)-'0';
                if(play[iClick].getName().charAt(1)=='2'&&judge==1){
                    if (Man >= 0 && Man < 4) {
                        System.out.println("车吃");
                        chessRule.carEat(play[Man], play,play[iClick], regretList, Man,iClick);
                    }
                    if (Man >= 4 && Man < 8) {
                        System.out.println("马吃");
                        chessRule.horseEat(play[Man], play,play[iClick], regretList, Man,iClick);
                    }
                    if (Man >= 8 && Man < 12) {
                        System.out.println("象吃");
                        chessRule.elephantEat(play[Man], play,play[iClick], regretList, Man,iClick);
                    }
                    if (Man >= 12 && Man < 16) {
                        System.out.println("士吃");
                        chessRule.chapEat(play[Man], play,play[iClick], regretList, Man,iClick);
                    }
                    if (Man >= 16 && Man < 26) {
                        System.out.println("兵吃");
                        chessRule.solidEat(play[Man], play,play[iClick], regretList, Man,iClick);
                    }
                    if (Man >= 26 && Man < 30) {
                        System.out.println("炮吃");
                        chessRule.cannonEat(play[Man], play,play[iClick], regretList, Man,iClick);
                    }
                    if (Man == 30 || Man == 31) {
                        System.out.println("帅吃");
                        chessRule.masterEat(play[Man], play,play[iClick], regretList, Man,iClick);
                    }
                    //吃子判断
                    if(play[iClick].getX()==play[Man].getX()&&play[iClick].getY()==play[Man].getY()){
                        //判断胜利
                        if(chessRule.masterMeet(play)==1){
                            JOptionPane.showMessageDialog(this,"红棋胜利");
                            text.setText("游戏结束，红棋胜");
                            chessManClick=false;
                            gameIsOver=true;
                            return;
                        }
                        if(play[31].isVisible()==false){//红棋帅被吃
                            JOptionPane.showMessageDialog(this,"黑棋胜利");
                            text.setText("游戏结束，黑棋胜");
                            chessManClick=false;
                            gameIsOver=true;
                            return;
                        }
                        chessPlayClick=2;
                        text.setText("红棋走");
                        chessManClick=false;
                    }
                }//吃子状态
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    //棋子点击时的闪烁
    @Override
    public void run() {
        while (true){
            if(chessManClick){
                play[Man].setVisible(false);//取消显示
                //线程休眠时，可能会等待cpu其它线程的结束，使用用try去除异常
                try{
                    tmain.sleep(200);
                }catch (Exception e){
                    e.printStackTrace();//输出错误的状态
                }
                play[Man].setVisible(true);//显示棋子
                for (int i = 0; i < 32; i++) {
                    if(i!=Man&&play[i].died==false)
                        play[i].setVisible(true);
                }//当点击另一个棋子时，而且棋子没有别吃，这个棋子继续显示
            }
            else {//当点击工具栏的时操作
                text.setVisible(false);
                try {
                    tmain.sleep(250);
                }catch (Exception e){
                    e.printStackTrace();
                }
                text.setVisible(true);
            }
            try {//闪烁
                tmain.sleep(350);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
