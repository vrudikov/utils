package com.blackhorse.utils.modules.audio;

import com.blackhorse.utils.api.IUtility;
import com.blackhorse.utils.exceptions.UtilityExecutionException;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.File;
import java.io.IOException;

/**
 * Created by Valentin
 */
public class BuildDirContent implements IUtility {

    public static void main(String[] args) {
        new BuildDirContent().execute();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void execute() throws UtilityExecutionException {
        File torrentDir = new File("c:\\Downloads\\Vineyard Christian Music (1990 - 2012)");

        File[] files = torrentDir.listFiles();
        assert files != null;
        for (File albumDir : files) {
            AlbumInfo albumInfo = new AlbumInfo();

            processDir(albumDir, albumInfo);

            String albumBitrate = "" + albumInfo.minBitrate;
            if (albumInfo.minBitrate != albumInfo.maxBitrate) {
                albumBitrate += " - " + albumInfo.maxBitrate;
            }
            long minutes = albumInfo.albumTime / 60;
            long seconds = (albumInfo.albumTime - (minutes * 60));
            String albumStructure = "[spoiler=\"" + albumDir.getName() + " (" + albumBitrate + " kbps) " + minutes + ":" + (seconds < 10 ? "0" + seconds : seconds) + "\"]\n";
            //albumStructure += "[img=right]#[/img]\n";
            albumStructure += "[b]Треклист[/b]:\n" + albumInfo.albumContent + "[/spoiler]";
            System.out.println(albumStructure);
        }
    }

    private void processDir(File albumDir, AlbumInfo albumInfo) {
        if (albumDir == null) return;

        File[] files = albumDir.listFiles();
        if (files != null) {
            for (File albumFile : files) {
                if (albumFile.isDirectory()) {
                    processDir(albumFile, albumInfo);
                } else {
                    processFile(albumFile, albumInfo);
                }
            }
        }
    }

    private class AlbumInfo {
        int minBitrate = 0;
        int maxBitrate = 0;
        String albumContent = "";
        long albumTime = 0;
    }

    private void processFile(File albumFile, AlbumInfo albumInfo) {
        albumInfo.albumContent += albumFile.getName().replace(".mp3", "") + "\n";

        try {
            Mp3File mp3file = new Mp3File(albumFile);
            albumInfo.albumTime += mp3file.getLengthInSeconds();


            if (albumInfo.minBitrate == 0) {
                albumInfo.minBitrate = mp3file.getBitrate();
            }
            if (mp3file.getBitrate() < albumInfo.minBitrate) {
                albumInfo.minBitrate = mp3file.getBitrate();
            }
            if (albumInfo.maxBitrate == 0) {
                albumInfo.maxBitrate = mp3file.getBitrate();
            }
            if (mp3file.getBitrate() > albumInfo.maxBitrate) {
                albumInfo.maxBitrate = mp3file.getBitrate();
            }
        } catch (InvalidDataException e) {
            UtilityExecutionException.throwNew();
        } catch (UnsupportedTagException e) {
            UtilityExecutionException.throwNew();
        } catch (IOException e) {
            UtilityExecutionException.throwNew();
        }
    }
}
