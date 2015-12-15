/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revisiuts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NARK
 */
public class RevisiUTS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            // TODO code application logic here
            Socket Listen=new Socket("10.151.43.147",6666);
            
            Scanner scan=new Scanner(System.in);
            String username;
            
            OutputStream os=Listen.getOutputStream();
            InputStream is=Listen.getInputStream();
            
            byte[] buffing=new byte[150];
            is.read(buffing);
            String wawa=new String(buffing);
            int mamam=0;
            mamam=wawa.lastIndexOf("\n");
            
            System.out.println(wawa.trim());
            username=scan.nextLine();
            
            username="Username:"+username+"\n";
            os.write(username.getBytes());
            os.flush();
            
            System.out.println(username);
            
            while(true){
           
            //    is=Listen.getInputStream();
                String out;
                String in;
                
                byte[] buf=new byte[500];
                int k=is.read(buf);
                String hao=new String(buf);
                //System.out.println("hao:\t"+hao);
                in=new String();
                buf=new byte[500];
                String ppa=hao.substring(0, 5);
                System.out.println(hao);
                if(!ppa.equalsIgnoreCase("Hash:")){
                k=is.read(buf);
                in=new String(buf);
                //System.out.println(k);
                System.out.println(in);
                
                int ha=in.indexOf("\n");
                String ma=in.substring(0,ha);
                }
                
                if("Hash:".equalsIgnoreCase(ppa)){
                    String dama=hao.substring(6);
                    int ada=dama.indexOf("\n");
                    out="Hash:"+dama.substring(ada+1)+"\n";
                //    System.out.println("out:\t\t"+out);
                }
                else{
                    String ka=in;
                    int total=0;
                    int aas=0;
                    int operator=-2;
                    int kakah=0;
                        
                    while(true){
                        int o=0;
                        o=ka.indexOf(" ");
                        String lla=ka.substring(0,o);
                        if(kakah==3){
                            break;
                        }
                        else if("+".equals(lla)){
                            operator=1;
                            ka=ka.substring(o+1);
                            kakah=kakah+1;
                        }
                        else if("-".equals(lla)){
                            operator=2;
                            ka=ka.substring(o+1);
                            kakah=kakah+1;
                        }
                        else if("x".equals(lla)){
                            operator=3;
                            ka=ka.substring(o+1);
                            kakah=kakah+1;
                        }
                        else if("mod".equals(lla)){
                            operator=4;
                            ka=ka.substring(o+1);
                            kakah=kakah+1;
                        }
                        else{
                        //    System.out.println("\t\tLLA: "+lla);
                            aas=Integer.parseInt(lla);
                            if(operator==-2){
                                total=aas;
                            }
                            ka=ka.substring(o+1);
                            kakah=kakah+1;
                            if(operator==1){
                                total=total+aas;
                                operator=-1;
                            }
                            else if(operator==2){
                                total=total-aas;
                                operator=-1;
                            }
                            else if(operator==3){
                                total=total*aas;
                                operator=-1;
                            }
                            else if(operator==4){
                                total=total%aas;
                                operator=-1;
                            }
                        }
                   //     System.out.println("\t\tLOOPING");
                    }
                    out="Result:"+total+"\n";
                    System.out.println(total);
                }
                //System.out.println("\t\tSend");
                os.write(out.getBytes());
                os.flush();
            }
            
            //is.close();
            //os.close();
            //Listen.close();
            
        } catch (IOException ex) {
            Logger.getLogger(RevisiUTS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
