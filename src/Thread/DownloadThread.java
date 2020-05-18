package Thread;

import java.io.IOException;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DownloadThread extends Thread{
    URI uri;
    int size;
    Path download;

    public DownloadThread(String path) {
        try {
            this.uri = new URI(path);
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            URLConnection urlConnection = uri.toURL().openConnection();
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            size = urlConnection.getContentLength();
            download = Paths.get("").toAbsolutePath().resolve("thread_file.txt").normalize();

            if (Files.exists(download)){
                Files.delete(download);
            }

            Files.copy(urlConnection.getInputStream(), download);

        } catch (MalformedURLException e) {
            System.out.println("Неверно указан путь");
        } catch (IOException e) {
            System.out.println("Не удалось получить данные");
        }

    }

    public void percentOfDownloading() {
        try {
            if (Thread.currentThread().getState().equals(State.TERMINATED)) {
                System.out.println("100%");
                return;

            }
            System.out.println((Files.size(download) * 1.0f / size) * 100 + "%");
        } catch (IOException e) {
            System.out.println("Ошибка в получении данных из файла");
        }
        catch (NullPointerException e) {
            System.out.println("Файл не начал скачиваться");
        }
    }
}