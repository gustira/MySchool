package com.enigma.bootcamp.util;

public class GenerateId {

	public static String getNum(String lastId, String code) {

		int newId = Integer.parseInt(lastId) + 1;
		int lengthId = String.valueOf(newId).length();

		String stringId;
		if (lengthId == 1) {
			stringId = code + "00000" + newId;
		} else if (lengthId == 2) {
			stringId = code + "0000" + newId;
		} else if (lengthId == 3) {
			stringId = code + "000" + newId;
		} else if (lengthId == 4) {
			stringId = code + "00" + newId;
		} else if (lengthId == 5) {
			stringId = code + "0" + newId;
		} else {
			stringId = code + newId;
		}
		return stringId;
	}

	public static String getAccnumb(String lastId, String code) {

        int newId = Integer.parseInt(lastId) + 1;
        int lengthId = String.valueOf(newId).length();

        String stringId;
        if (lengthId == 1) {
            stringId = code+ "0000000" + newId;
        } else if (lengthId == 2) {
            stringId = code+ "000000" + newId;
        } else if (lengthId == 3) {
            stringId = code + "00000" + newId;
        } else if (lengthId == 4) {
            stringId = code + "0000" + newId;
        } else if (lengthId == 5) {
            stringId = code + "000" + newId;
        }else if (lengthId == 6) {
            stringId = code + "00" + newId;
        }else if (lengthId == 7) {
            stringId = code + "0" + newId;
        } else {
            stringId = code + newId;
        }
        return stringId;
    }
}
