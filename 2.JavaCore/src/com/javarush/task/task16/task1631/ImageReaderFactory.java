package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;


public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes iT){
        ImageReader ir=null;

            if (ImageTypes.BMP.equals(iT)) ir = new BmpReader();
            else if(ImageTypes.JPG.equals(iT))   ir = new JpgReader();
            else if(ImageTypes.PNG.equals(iT))   ir = new PngReader();
            else throw new IllegalArgumentException("Неизвестный тип картинки");

        return ir;
    }
}

