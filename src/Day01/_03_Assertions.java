package Day01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Assertions {

    // Yeşil tik : test'de hata yok
    // Sarı çarpı : test'de hata var
    // Beyaz : test çalıştırılamadı. skip

    @Test
    void EqualOrnek(){
        String s1 = "Merhaba";
        String s2 = "İyi akşamlar";


        Assert.assertEquals(s1,s2,"Karşılaştırma sonucu"); // oluşan,beklenen, "Hata başlığı"
        // Actual : oluşan,olan
        // Expected : Beklenen
    }

    @Test
    void NotEqualOrnek(){
        String s1 = "Merhaba";
        String s2 = "İyi akşamlar";


        Assert.assertNotEquals(s1,s2,"Karşılaştırma sonucu"); // oluşan,beklenen, "Hata başlığı"
        // Actual : oluşan,olan
        // Expected : Beklenen
    }

    @Test
    void TrueOrnek(){
        int s1 =55;
        int s2 =555;


        Assert.assertTrue(s1==s2,"Karşılaştırma sonucu"); // oluşan,beklenen, "Hata başlığı"
        // Actual : oluşan,olan
        // Expected : Beklenen
    }

    @Test
    void NulleOrnek(){
        String s1 =null;

        Assert.assertNull(s1,"Karşılaştırma sonucu"); // oluşan,beklenen, "Hata başlığı"
        // Actual : olan
        // Expected : Beklenen
    }

    @Test
    void direkFail(){
        int a =55;
        if(a == 55)
            Assert.fail(); //

    }


}
