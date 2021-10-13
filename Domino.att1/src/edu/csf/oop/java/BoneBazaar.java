package edu.csf.oop.java;

import java.util.Random;

public class BoneBazaar {

  private class LinkedBones {
        public Bone bone;
        public LinkedBones next;

        public LinkedBones(Bone value,LinkedBones next) {
            this.bone = value;
            this.next = next;
        }

        public LinkedBones(Bone value) {
            this(value, null);
        }

        public LinkedBones() {
            this(null);
        }
    }

    private LinkedBones head = null;
    private LinkedBones tail = null;

    private int size = 28;

    public BoneBazaar() {
        Bone[] bones = new Bone[28];
        int a = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if ((j+1+i) <= 6)
                bones[a] = new Bone(j, j+1+i);
                a++;
            }
        }

        Random random = new Random();
        for (int i = 0; i < 28; i++) {
            int randomBone = random.nextInt(28);
            Bone bone = bones[i];
            bones[i] = bones[randomBone];
            bones[randomBone] = bones[i];
        }

        for (int i = 0; i < 28; i++) {
            head = new LinkedBones(bones[i], head);
            if (i == 0) {
                tail = head;
            }
        }
    }

    public Bone takeBone() throws Exception {
        if (size == 0) {
            throw new Exception("Stack is empty");
        }
        Bone bone = head.bone;
        head = head.next;
        size--;
        return bone;
    }



    public int getSize() {
        return size;
    }
}
