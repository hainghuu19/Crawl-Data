import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;





public class Main {

    public static void main(String[] args) {
        try {
            String url = "https://www.twinkl.com.vn/teaching-wiki/danh-sach-nien-hieu-va-the-thu-cac-doi-vua-viet-nam";
            Document doc = Jsoup.connect(url).get();
            Element table = doc.select("table").first();
            Elements rows = table.select("tr");
            List<Vua> dsVua = new ArrayList<>();


            for (int i = 1; i < rows.size(); i++) {
                Element row = rows.get(i);
                Elements cells = row.select("td");
                String nienHieu = cells.get(0).text();
                String chuHan = cells.get(1).text();
                String tayLich = cells.get(2).text();
                String tenVua = cells.get(3).text();

                Vua vua = new Vua(nienHieu, chuHan, tayLich, tenVua);
                dsVua.add(vua);

                }

               for (Vua vua : dsVua){
                   System.out.println( "Niên hiệu: " + vua.getNienHieu() );
                   System.out.println( "Chữ hán: " + vua.getChuHan() );
                   System.out.println( "Tây lịch: " + vua.getTayLich() );
                   System.out.println( "Tên: " + vua.getTenVua() );
                   System.out.println("\n");
               }
        }
       catch (IOException e){
                e.printStackTrace();
            }


        }


    }

