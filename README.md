# Terfi Projesi

Bu proje, **Selenium**, **Gauge** ve Java kullanılarak yazılmıştır.

## Özellikler

- **Test Frameworkü**: Testler Gauge frameworkü ile yazılmıştır.
- **Raporlama**: Extent Report kullanılarak test raporları oluşturulur. Raporlar report klasöründen erişilebilir. HTML formatındaki raporlara bu klasörden ulaşabilirsiniz.
- **Tarayıcı Yönetimi**: `src/test/resources/config.properties` dosyasından tarayıcı seçimi yapılabilir.
- **Lokator Yönetimi**: Tüm lokator bilgileri `src/test/resources/locators.json` dosyasından okunur.
- **Senaryolar**: Projede aşağıdaki gibi senaryolar bulunmaktadır:

    - **Yanlış Kullanıcı İle Giriş İşlemi**
    - **Doğru Kullanıcı İle Giriş İşlemi**
    - **Hesap Adı Değişikliği İşlemi**
    - **Hesaba Para Gönderme İşlemi** --> Bu senaryo fail vermektedir girilen miktarın üstüne otomatik olarak 100 eklendiği için test patlar !!!
    - **Hesaba Eksi Tutar İle Para Gönderme İşlemi** --> Bu senaryo fail vermektedir, eksi para yollanabiliyor !!!
    - **Eksik CVV İle Para Yükleme İşlemi**
    - **Yanlış Kart Tarihi İle Para Yükleme İşlemi**
    - **Uzun Kart Numarası İle Para Yükleme İşlemi**
    - **Kısa Kart Numarası İle Para Yükleme İşlemi**
    - **Yanlış Kart Numarası İle Para Yükleme İşlemi**
    - **Doğru Kart Bilgileri İle Para Yükleme İşlemi**


## Nasıl Çalıştırılır?

1. Proje kök dizininde `pom.xml` dosyası bulunduğundan Maven kullanılarak bağımlılıkları yükleyin:
   ```bash
   mvn clean install
   ```
2. Testleri çalıştırmak için aşağıdaki komutu kullanın:
   ```bash
   mvn gauge:execute
   ```
3. Sonuçları görmek için `reports` klasörü altındaki raporları inceleyebilirsiniz.

## Tarayıcı Ayarları

Tarayıcıyı değiştirmek için `config.properties` dosyasını düzenleyin:
```
browser=chrome
```
Alternatif olarak `firefox` , `safari` veya `edge` gibi diğer tarayıcılar seçilebilir.

## Lokator Yönetimi

Lokatorlar `locators.json` dosyasında JSON formatında saklanmaktadır. Örnek bir yapı:
```json
{
  "elementName": "logOutBtn",
  "elementValue": "//div[text() = \"Logout\"]",
  "elementType": "xpath"
}
```

