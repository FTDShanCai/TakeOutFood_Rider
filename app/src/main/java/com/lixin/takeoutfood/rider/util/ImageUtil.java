package com.lixin.takeoutfood.rider.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * User : yh
 * Date : 16/12/6
 */

public class ImageUtil {
    public static String pathUrl = Environment.getExternalStorageDirectory()
            .getPath() + "/Photo_LJ/";


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    public static String imageFile2Base64(String file) {
        try {
            FileInputStream input = new FileInputStream(file);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPurgeable = true;
//            options.inSampleSize = 5;
            final Bitmap photo = BitmapFactory.decodeStream(input, null, options);
            Log.e("image............", photo.getHeight() + "," + photo.getWidth());
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            if ((photo.getHeight() > 2000 || photo.getWidth() > 2000) && (photo.getHeight() < 3500 || photo.getWidth() < 3500)) {
                photo.compress(Bitmap.CompressFormat.JPEG, 3, stream);
            } else if (photo.getHeight() > 3500 || photo.getWidth() > 3500) {
                photo.compress(Bitmap.CompressFormat.JPEG, 1, stream);
            } else {
                photo.compress(Bitmap.CompressFormat.JPEG, 8, stream);
            }


            byte[] b = stream.toByteArray();
            String dst = Base64.encodeToString(b, Base64.DEFAULT);
            return dst;
        } catch (Exception e) {
            return null;
        }
    }

    public static String imageFile2Base642(String file) {
        try {
            FileInputStream input = new FileInputStream(file);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPurgeable = true;
//            options.inSampleSize = 5;
            final Bitmap photo = BitmapFactory.decodeStream(input, null, options);
            Log.e("image............", photo.getHeight() + "," + photo.getWidth());
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            if ((photo.getHeight() > 2000 || photo.getWidth() > 2000) && (photo.getHeight() < 3500 || photo.getWidth() < 3500)) {
                photo.compress(Bitmap.CompressFormat.JPEG, 3, stream);
            } else if (photo.getHeight() > 3500 || photo.getWidth() > 3500) {
                photo.compress(Bitmap.CompressFormat.JPEG, 1, stream);
            } else {
                photo.compress(Bitmap.CompressFormat.JPEG, 8, stream);
            }


            byte[] b = stream.toByteArray();
            String dst = Base64.encodeToString(b, Base64.DEFAULT);
            return dst;
        } catch (Exception e) {
            return null;
        }
    }

    public static String imageFile2Base643(String file) {
        try {
            FileInputStream input = new FileInputStream(file);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPurgeable = true;
//            options.inSampleSize = 5;
            final Bitmap photo = BitmapFactory.decodeStream(input, null, options);
            Log.e("image............", photo.getHeight() + "," + photo.getWidth());
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            if ((photo.getHeight() > 2000 || photo.getWidth() > 2000) && (photo.getHeight() < 3500 || photo.getWidth() < 3500)) {
                photo.compress(Bitmap.CompressFormat.JPEG, 3, stream);
            } else if (photo.getHeight() > 3500 || photo.getWidth() > 3500) {
                photo.compress(Bitmap.CompressFormat.JPEG, 1, stream);
            } else {
                photo.compress(Bitmap.CompressFormat.JPEG, 8, stream);
            }


            byte[] b = stream.toByteArray();
            String dst = Base64.encodeToString(b, Base64.DEFAULT);
            return dst;
        } catch (Exception e) {
            return null;
        }
    }


    public static Bitmap compressScale(Bitmap image) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);

        // 判断如果图片大于1M,进行压缩避免在生成图片（BitmapFactory.decodeStream）时溢出
        if (baos.toByteArray().length / 1024 > 1024) {
            baos.reset();// 重置baos即清空baos
            image.compress(Bitmap.CompressFormat.JPEG, 80, baos);// 这里压缩50%，把压缩后的数据存放到baos中
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        // 开始读入图片，此时把options.inJustDecodeBounds 设回true了
        newOpts.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
        newOpts.inJustDecodeBounds = false;
        int w = newOpts.outWidth;
        int h = newOpts.outHeight;
//        Log.i(TAG, w + "---------------" + h);
        // 现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
        // float hh = 800f;// 这里设置高度为800f
        // float ww = 480f;// 这里设置宽度为480f
        float hh = 512f;
        float ww = 512f;
        // 缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        int be = 1;// be=1表示不缩放
        if (w > h && w > ww) {// 如果宽度大的话根据宽度固定大小缩放
            be = (int) (newOpts.outWidth / ww);
        } else if (w < h && h > hh) { // 如果高度高的话根据高度固定大小缩放
            be = (int) (newOpts.outHeight / hh);
        }
        if (be <= 0)
            be = 1;
        newOpts.inSampleSize = be; // 设置缩放比例
        // newOpts.inPreferredConfig = Config.RGB_565;//降低图片从ARGB888到RGB565

        // 重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
        isBm = new ByteArrayInputStream(baos.toByteArray());
        bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);

        return compressImage(bitmap);// 压缩好比例大小后再进行质量压缩

        //return bitmap;
    }

    public static Bitmap compressImage(Bitmap image) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);// 质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        int options = 90;

        while (baos.toByteArray().length / 1024 > 500) { // 循环判断如果压缩后图片是否大于100kb,大于继续压缩
            baos.reset(); // 重置baos即清空baos
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);// 这里压缩options%，把压缩后的数据存放到baos中
            options -= 10;// 每次都减少10
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());// 把压缩后的数据baos存放到ByteArrayInputStream中
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);// 把ByteArrayInputStream数据生成图片
        return bitmap;
    }

    public static Bitmap getBitmapFromPath(String path) {

        if (!new File(path).exists()) {
            System.err.println("getBitmapFromPath: file not exists");
            return null;
        }
        // Bitmap bitmap = Bitmap.createBitmap(1366, 768, Config.ARGB_8888);
        // Canvas canvas = new Canvas(bitmap);
        // Movie movie = Movie.decodeFile(path);
        // movie.draw(canvas, 0, 0);
        //
        // return bitmap;

        byte[] buf = new byte[1024 * 1024];// 1M
        Bitmap bitmap = null;

        try {

            FileInputStream fis = new FileInputStream(path);
            int len = fis.read(buf, 0, buf.length);
            bitmap = BitmapFactory.decodeByteArray(buf, 0, len);
            if (bitmap == null) {
                System.out.println("len= " + len);
                System.err
                        .println("path: " + path + "  could not be decode!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        return bitmap;
    }


    public static String convertIconToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();// outputstream
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] appicon = baos.toByteArray();// 转为byte数组
        return Base64.encodeToString(appicon, Base64.DEFAULT);

    }


    /**
     * 压缩生成的Bitmap大小防止OOM
     * path 图片路径
     * scalSize 压缩倍数
     */
    public static Bitmap loadResBitmap(String path, int scalSize) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        if (scalSize != 0) {
            options.inSampleSize = scalSize;
        }
        Bitmap bmp = BitmapFactory.decodeFile(path, options);
        return bmp;
    }


    /**
     * 压缩图片
     * path 路径
     */
    public static Bitmap getBitmapFromPath2(String path) {
        Bitmap bitmap = loadResBitmap(path, 0);
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int hight = bitmap.getHeight();


        Bitmap newbm = null;
        if (width < 100 | hight < 100) {
            newbm = bitmap;
        } else if ((width < 500 && width >= 100) | (hight < 500 && hight >= 100)) {
            float scaleWidth = ((float) width * 1 / 2) / width;
            float scaleHeight = ((float) hight * 1 / 2) / hight;
            Matrix matrix = new Matrix();
            matrix.postScale(scaleWidth, scaleHeight);
            newbm = Bitmap.createBitmap(bitmap, 0, 0, width, hight, matrix, true);
        } else if ((width >= 500 && width < 1000) | (hight >= 500 && hight < 1000)) {
            float scaleWidth = ((float) width * 1 / 4) / width;
            float scaleHeight = ((float) hight * 1 / 4) / hight;
            Matrix matrix = new Matrix();
            matrix.postScale(scaleWidth, scaleHeight);
            newbm = Bitmap.createBitmap(bitmap, 0, 0, width, hight, matrix, true);
        } else if ((width >= 1000 && width < 1500) | (hight >= 1000 && hight < 1500)) {
            float scaleWidth = ((float) width * 1 / 8) / width;
            float scaleHeight = ((float) hight * 1 / 8) / hight;
            Matrix matrix = new Matrix();
            matrix.postScale(scaleWidth, scaleHeight);
            newbm = Bitmap.createBitmap(bitmap, 0, 0, width, hight, matrix, true);
        } else if ((width >= 1500 && width < 2000) | (hight >= 1500 && hight < 2000)) {
            float scaleWidth = ((float) width * 1 / 10) / width;
            float scaleHeight = ((float) hight * 1 / 10) / hight;
            Matrix matrix = new Matrix();
            matrix.postScale(scaleWidth, scaleHeight);
            newbm = Bitmap.createBitmap(bitmap, 0, 0, width, hight, matrix, true);
        } else if ((width >= 2000 && width < 5000) | (hight >= 2000 && hight < 5000)) {
            float scaleWidth = ((float) width * 1 / 12) / width;
            float scaleHeight = ((float) hight * 1 / 12) / hight;
            Matrix matrix = new Matrix();
            matrix.postScale(scaleWidth, scaleHeight);
            newbm = Bitmap.createBitmap(bitmap, 0, 0, width, hight, matrix, true);
        } else {
            float scaleWidth = ((float) width * 1 / 18) / width;
            float scaleHeight = ((float) hight * 1 / 18) / hight;
            Matrix matrix = new Matrix();
            matrix.postScale(scaleWidth, scaleHeight);
            newbm = Bitmap.createBitmap(bitmap, 0, 0, width, hight, matrix, true);
        }
        return newbm;
    }

    //请求网络图片
    public static Bitmap returnBitMap(String url) {
        URL myFileUrl = null;
        Bitmap bitmap = null;
        InputStream is = null;
        try {
            myFileUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            HttpURLConnection conn = (HttpURLConnection) myFileUrl.openConnection();
            conn.setDoInput(true);
            conn.connect();
            is = conn.getInputStream();
            if (is != null) {
                bitmap = BitmapFactory.decodeStream(is);
                return bitmap;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
            }
        }
        return null;
    }

    public static File saveBitmapFile(Bitmap bitmap) {
        File file = new File(Environment.getExternalStorageDirectory(), "/temp/" + System.currentTimeMillis() + ".png");
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

    public static String Bitmap2StrByBase64(Bitmap bit) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bit.compress(Bitmap.CompressFormat.JPEG, 40, bos);//参数100表示不压缩
        byte[] bytes = bos.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    // 根据路径获得图片并压缩，返回bitmap用于显示
    public static Bitmap getSmallBitmap(String filePath) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, 480, 800);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeFile(filePath, options);
    }

    //计算图片的缩放值
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSampleSize;
    }

}
