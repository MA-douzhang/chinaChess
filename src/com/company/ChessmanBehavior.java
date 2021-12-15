package com.company;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ChessmanBehavior extends JLabel {
    boolean died=false;

    ChessmanBehavior(Icon image){
        super(image);
    }
    //音效
    public void playSounds(){
        try {
            File path=new File("sounds/cannon.wav");
            URL url=path.toURI().toURL();//需先转uri再转url
            AudioClip Pow= Applet.newAudioClip(url);
            Pow.play();
            //System.out.println("播放声音");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
    public void playSoundDown(){
        try {
            File path=new File("sounds/luozi.wav");
            URL url=path.toURI().toURL();//需先转uri再转url
            AudioClip Pow= Applet.newAudioClip(url);
            Pow.play();
            //System.out.println("播放声音");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
    public void playSoundEat(){
        try {
            File path=new File("sounds/eat.wav");
            URL url=path.toURI().toURL();//需先转uri再转url
            AudioClip Pow= Applet.newAudioClip(url);
            Pow.play();
            //System.out.println("播放声音");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }


}
