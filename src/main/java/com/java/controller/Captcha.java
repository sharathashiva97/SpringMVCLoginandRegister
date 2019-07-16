package com.java.controller;

import java.util.Random;



public class Captcha {

      public static void main(String args[])

      {

            callCap();

      }

 

      public static void callCap() {

           

            //System.out.println(createCap());

      }

 

      public static String createCap() {

            Random ran=new Random();

            int l=7+(Math.abs(ran.nextInt()%3));

            //System.out.println(l);

            StringBuffer capBuff=new StringBuffer();

            for(int i=0;i<l;i++)

            {

                  int bcase=Math.abs(ran.nextInt())%62;

                  int charNum=0;

                  if(bcase<26)

                  {

                        charNum=65+bcase;

                  }

                  else if(bcase<52)

                  {

                        charNum=97+(bcase-26);

                  }

                  else

                  {

                        charNum=48+(bcase-52);

                  }

                  capBuff.append((char)charNum);

            }

           

            return capBuff.toString();

      }

      }