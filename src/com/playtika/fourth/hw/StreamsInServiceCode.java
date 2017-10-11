package com.playtika.fourth.hw;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamsInServiceCode {


    //Good
//             private List<MysteryBonusInfo> removeFirstBonus(MysteryBonusesDocument mysteryBonusesDocument) {
//                return mysteryBonusesDocument
//            .availableToPlayBonuses
//            .stream()
//            .skip(1)
//            .collect(toList());
//            }

    //----------------------------------------------------------------------------------//

    //Code can be modify
//    private final List<MegaBonusSegment> wedges;
//
//    public MegaBonusSegment getBySegmentId(int segmentId) {
//
//        for (MegaBonusSegment wedge : wedges) {
//            if (wedge.getSegmentId() == segmentId) {
//                return wedge;
//            }
//        }
//        return null;
//    }


    //To
//  public MegaBonusSegment getBySegmentId(int segmentId){
//    return wedges.stream()
//    .filter(w->w.getSegmentId()==segmentId)
//    .findFirst().orElse(null);
//    }

//----------------------------------------------------------------------------------------//
}