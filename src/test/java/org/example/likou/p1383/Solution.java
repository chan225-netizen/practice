package org.example.likou.p1383;

import java.util.*;

class Solution {
    class Staff {
        int s, e;

        public Staff(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        final int MODULO = 1000000007;
        List<Staff> list = new ArrayList<Staff>();
        PriorityQueue<Staff> queue = new PriorityQueue<Staff>(new Comparator<Staff>() {
            //速度升序
            public int compare(Staff staff1, Staff staff2) {
                return staff1.s - staff2.s;
            }
        });
        for (int i = 0; i < n; ++i) {
            list.add(new Staff(speed[i], efficiency[i]));
        }
        Collections.sort(list, new Comparator<Staff>() {
            public int compare(Staff staff1, Staff staff2) {
                return staff2.e - staff1.e;
            }
        });
        long ans = 0, sum = 0;
        for (int i = 0; i < n; ++i) {
            Staff staff = list.get(i);
            long minE = staff.e;
            long sumS = sum + staff.s;
            ans = Math.max(ans, sumS * minE);
            queue.offer(staff); 
            sum += staff.s;
            if (queue.size() == k) {
                sum -= queue.poll().s;
            }
        }
        return (int) (ans % MODULO);
    }

    /**
     *        int []speed={2,10,3,1,5,8};
     *        int []efficiency={5,4,3,9,7,2};
     * 先按照效率降序排列
        int []speed={1,5,2,10,3,8};
        int []efficiency={9,7,5,4,3,2};

     i=0:
     ans=0,sum=0;
     [1,9]
     minE=9,sumS=0+1=1,ans=max(0,1*9)=9
     把【1，9】放到队列中
     sum=0+1=1
     i=1:
     ans=9,sum=1;
     [5,7]
     minE=7,sumS=1+5=6,ans=max(9,42)=42
     把【5，7】放到队列中
     sum=1+5=6






     */


}