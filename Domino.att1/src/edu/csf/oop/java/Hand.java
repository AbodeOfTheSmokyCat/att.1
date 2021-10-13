package edu.csf.oop.java;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Bone> bones1 = new ArrayList<>();

    public void fillFromBazaar(BoneBazaar bones) throws Exception {

        while (bones1.size() < 7 && bones.getSize() > 0) {
            addBone(bones.takeBone());
        }
    }

    public void addBone(Bone bone) {
        bones1.add(bone);
    }

    public int getSize() {
        return bones1.size();
    }

    public boolean contains(Bone bone) {
        return bones1.contains(bone);
    }

    public void useBone(BoneBazaar bones)  throws Exception {
        addBone(bones.takeBone());
    }

}
