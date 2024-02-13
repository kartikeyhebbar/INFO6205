package edu.neu.coe.info6205.union_find;

import java.util.Random;
import java.util.Scanner;

public class HWQUPC_Solution {

    // generate random pairs of integers between 0 and n-1, calling connected() to determine if they are connected and union() if not
    private static int count(int n) {
        UF_HWQUPC uf = new UF_HWQUPC(n);
        int connections = 0;
        Random r = new Random();
        while(uf.count>1){
            int p = r.nextInt(n);
            int q = r.nextInt(n);
            if(!uf.connected(p,q)){
                uf.union(p,q);
            }
            connections+=1;
        }
        return connections;
    }

    // Main method:
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of sites (N): ");
        while(sc.hasNext()) {
            int N = sc.nextInt();
            int count = count(N);
            System.out.println("No. of connections generated: " + count);
            System.out.println("Enter the number of sites (N): ");
        }
    }

}