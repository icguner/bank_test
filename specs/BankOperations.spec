Banka Uygulamasi Testi
======================
Created by Isocan on 10.01.2025

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
     
Yanlış Kullanıcı İle Giriş İşlemi
----------------
tags:yanlisKullaniciIleGirisIslemi
* "https://catchylabs-webclient.testinium.com" adresine gidilir
* "test" ve "test" bilgileri ile uygulamaya giris yapilir
* Uygulamaya giriş yapılamadığı kontrol edilir

Doğru Kullanıcı İle Giriş İşlemi
--------------------------------
tags:dogruKullaniciIleGirisIslemi
* "https://catchylabs-webclient.testinium.com" adresine gidilir
* "ismailcan.guner@testinium.com" ve "241715@Iso" bilgileri ile uygulamaya giris yapilir
* Uygulamaya giriş yapıldığı kontrol edilir

Hesap Adı Değişikliği İşlemi
--------------------------------
tags:hesapAdiDegisikligi
* "https://catchylabs-webclient.testinium.com" adresine gidilir
* "ismailcan.guner@testinium.com" ve "241715@Iso" bilgileri ile uygulamaya giris yapilir
* Uygulamaya giriş yapıldığı kontrol edilir
* Key değeri "openMoneyTransferBtn" olan elemana tıklanır
* Edit account butonuna tıklanır
* Hesap adı "Site ÇOK KÖTÜ" olarak değiştirilir, kaydedilir
* Hesap adının "Site ÇOK KÖTÜ" olarak değiştirildiği kontrol edilir

Hesaba Para Gönderme İşlemi
--------------------------------
tags:hesapAdiDegisikligi
* "https://catchylabs-webclient.testinium.com" adresine gidilir
* "ismailcan.guner@testinium.com" ve "241715@Iso" bilgileri ile uygulamaya giris yapilir
* Uygulamaya giriş yapıldığı kontrol edilir
* Key değeri "openMoneyTransferBtn" olan elemana tıklanır
* Key değeri "transferMoneyBtn" olan elemana tıklanır
* "555" tutarı girilir, yollanır
* "555" yolladığım tutar son işlemlerde var mı kontrol edilir

Hesaba Eksi Tutar İle Para Gönderme İşlemi
--------------------------------
tags:hesapEksiTutarIleParaGondermeIslemi
* "https://catchylabs-webclient.testinium.com" adresine gidilir
* "ismailcan.guner@testinium.com" ve "241715@Iso" bilgileri ile uygulamaya giris yapilir
* Uygulamaya giriş yapıldığı kontrol edilir
* Key değeri "openMoneyTransferBtn" olan elemana tıklanır
* Key değeri "transferMoneyBtn" olan elemana tıklanır
* "-11111111111111111111111111" tutarı girilir, yollanır
* Tutarın gönderilmediği kontrol edilir

Eksik CVV İle Para Yükleme İşlemi
--------------------------------
tags:eksikCVVIleParaYuklemeIslemi
* "https://catchylabs-webclient.testinium.com" adresine gidilir
* "ismailcan.guner@testinium.com" ve "241715@Iso" bilgileri ile uygulamaya giris yapilir
* Uygulamaya giriş yapıldığı kontrol edilir
* Key değeri "openMoneyTransferBtn" olan elemana tıklanır
* Key değeri "addMoneyBtn" olan elemana tıklanır
* Kart sahibi "Site Berbat" olarak girilir
* Kart numarası "0000000000000000" olarak girilir
* Kart ay yıl bilgisi "1226" olarak girilir
* Kart cvv "67" olarak girilir
* Yatıralacak tutar "1500" olarak girilir
* "Too short" metni sayfada var mı kontrol edilir

Yanlış Kart Tarihi İle Para Yükleme İşlemi
--------------------------------
tags:yanlisKartTarihiIleParaYuklemeIslemi
* "https://catchylabs-webclient.testinium.com" adresine gidilir
* "ismailcan.guner@testinium.com" ve "241715@Iso" bilgileri ile uygulamaya giris yapilir
* Uygulamaya giriş yapıldığı kontrol edilir
* Key değeri "openMoneyTransferBtn" olan elemana tıklanır
* Key değeri "addMoneyBtn" olan elemana tıklanır
* Kart sahibi "Site Berbat" olarak girilir
* Kart numarası "0000000000000000" olarak girilir
* Kart ay yıl bilgisi "0000" olarak girilir
* Kart cvv "674" olarak girilir
* "Wrong date. Please give a correct date" metni sayfada var mı kontrol edilir

Uzun Kart Numarası İle Para Yükleme İşlemi
--------------------------------
tags:uzunKartNumarasiIleParaYuklemeIslemi
* "https://catchylabs-webclient.testinium.com" adresine gidilir
* "ismailcan.guner@testinium.com" ve "241715@Iso" bilgileri ile uygulamaya giris yapilir
* Uygulamaya giriş yapıldığı kontrol edilir
* Key değeri "openMoneyTransferBtn" olan elemana tıklanır
* Key değeri "addMoneyBtn" olan elemana tıklanır
* Kart sahibi "Site Berbat" olarak girilir
* Kart numarası "123412341234123412341234" olarak girilir
* "Too Long!" metni sayfada var mı kontrol edilir

Kısa Kart Numarası İle Para Yükleme İşlemi
--------------------------------
tags:kisaKartNumarasiIleParaYuklemeIslemi
* "https://catchylabs-webclient.testinium.com" adresine gidilir
* "ismailcan.guner@testinium.com" ve "241715@Iso" bilgileri ile uygulamaya giris yapilir
* Uygulamaya giriş yapıldığı kontrol edilir
* Key değeri "openMoneyTransferBtn" olan elemana tıklanır
* Key değeri "addMoneyBtn" olan elemana tıklanır
* Kart sahibi "Site Berbat" olarak girilir
* Kart numarası "3333" olarak girilir
* "Too Short!" metni sayfada var mı kontrol edilir

Yanlış Kart Numarası İle Para Yükleme İşlemi
--------------------------------
tags:yanlisKartNumarasiIleParaYuklemeIslemi
* "https://catchylabs-webclient.testinium.com" adresine gidilir
* "ismailcan.guner@testinium.com" ve "241715@Iso" bilgileri ile uygulamaya giris yapilir
* Uygulamaya giriş yapıldığı kontrol edilir
* Key değeri "openMoneyTransferBtn" olan elemana tıklanır
* Key değeri "addMoneyBtn" olan elemana tıklanır
* Kart sahibi "Site Berbat" olarak girilir
* Kart numarası "9999000099990000" olarak girilir
* Kart ay yıl bilgisi "1224" olarak girilir
* Kart cvv "674" olarak girilir
* Yatıralacak tutar "1500" olarak girilir
* Key değeri "addBtn" olan elemana tıklanır
* "1,500" yolladığım tutar son işlemlerde var mı kontrol edilir

Doğru Kart Bilgileri İle Para Yükleme İşlemi
--------------------------------
tags:yanlisKartBilgileriIleParaYuklemeIslemi
* "https://catchylabs-webclient.testinium.com" adresine gidilir
* "ismailcan.guner@testinium.com" ve "241715@Iso" bilgileri ile uygulamaya giris yapilir
* Uygulamaya giriş yapıldığı kontrol edilir
* Key değeri "openMoneyTransferBtn" olan elemana tıklanır
* Key değeri "addMoneyBtn" olan elemana tıklanır
* Kart sahibi "Site Berbat" olarak girilir
* Kart numarası "1234123412341234" olarak girilir
* Kart ay yıl bilgisi "1224" olarak girilir
* Kart cvv "674" olarak girilir
* Yatıralacak tutar "1500" olarak girilir
* Key değeri "addBtn" olan elemana tıklanır
* "1,500" yolladığım tutar son işlemlerde var mı kontrol edilir