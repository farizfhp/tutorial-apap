
# Tutorial APAP
## Authors
* **Fariz Habibie Permana** - *1906305833* - *APAP-C*

---
## Tutorial 4
### Pertanyaan
**Pertanyaan 1: Jelaskan perbedaan th:include dan th:replace!**

**th:include** dan **th:replace** keduanya memiliki fungsi yang sama, yaitu untuk memasukkan fragments ke dalam sebuah html lain. Perbedaannya yaitu apabila kita memiliki sebuah element div, lalu menggunakan th:replace, maka element div tersebut akan tergantikan oleh fragment yang kita ingin gunakan. Sedangkan, bila kita penggunakan th:include, maka fragment yang ingin digunakan akan berada di dalam div tersebut.

&nbsp;

**Pertanyaan 2: Jelaskan apa fungsi dari th:object!**

Fungsi dari th:object adalah untuk menspesifikasi object mana yang ingin kita gunakan pada sebuah element.

&nbsp;

**Pertanyaan 3: Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?**

Bila kita sudah menggunakan th:object, kita dapat langsung mengakses setiap attribute dari object tersebut dengan menggunakan simbol asterisk (*) tanpa harus memanggil nama objectnya di depannya. Sedangkan, bila kita menggunakan simbol ($), kita masih harus memanggil nama object tersebut di depan attribute yang ingin kita panggil.

&nbsp;


---
## Tutorial 3
### Pertanyaan
**Pertanyaan 1: Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model (@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)!**

**@AllArgsConstructor** adalah anotasi yang dapat meng-generate constructor yang memiliki argumen untuk setiap attribute pada data field class tersebut.

**@NoArgsConstructor** adalah notasi yang dapat meng-generate constructor yang tidak memiliki argumen.

**@Setter** dan **@Getter** adalah notasi yang dapat meng-generate method setter dan getter untuk setiap attribute non static.

**@Entity** berguna untuk mendefinisikan class sebagai sebuah table pada database.

**@Table** berguna sebagai penamaan table yang disimpan pada database.

&nbsp;

**Pertanyaan 2: Pada class BioskopDB, terdapat method findByNoBioskop, apakah kegunaan dari method tersebut?**

Kegunaan dari method tersebut adalah untuk mencari objek Bioskop berdasarkan value dari noBioskop yang diberikan sebagai argumen saat method tersebut dipanggil. 

&nbsp;

**Pertanyaan 3: Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn!**

Untuk memetakan relasi antara suatu entity dengan entity lain, kita dapat menggunakan @JoinTable dan @JoinColumn. **@JoinTable** menggunakan table yang berbeda saat memetakan relasi tersebut, sedangkan **@JoinColumn** memanfaatkan Foreign Key dari table tujuan dan menggunakan entity table tujuan. 

&nbsp;

**Pertanyaan 4: Pada class PenjagaModel, digunakan anotasi @JoinColumn pada atribut bioskop, apa kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa perbedaan nullable dan penggunaan anotasi @NotNull?**

**name** berfungsi sebagai nama dari JoinColumn antara entity Penjaga dan Bioskop. **referencedColumnName** adalah judul dari kolom yang menjadi referensi foreign key yang dipilih. **nullable** menjadi sifat dari entity tersebut, bila nilainya false maka entity tersebut tidak dapat bernilai null. Perbedaan antara **nullable** dan **@NotNull** adalah bila kita menggunakan anotasi @NotNull, validasi data terjadi sebelum query update dan insert dijalankan pada database.

&nbsp;

**Pertanyaan 5: Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER**

FetchType.LAZY digunakan agar data initialization tidak langsung dilakukan dari awal sehingga load timenya lebih rendah, tapi terdapat kemungkinan bahwa performance akan terganggu.

FetchType.EAGER digunakan agar data initialization langsung dilakukan dari awal sehingga performance lebih baik, tapi load time akan menjadi lebih lama.

CascadeType.ALL digunakan agar setiap operasi EntityManager yang dilakukan akan meng-cascade setiap entities yang memiliki relasi dengan entity tersebut.

&nbsp;


---
## Tutorial 2
### Pertanyaan
**Pertanyaan 1: Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link
berikut:**

**http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx&jumlahStudio=10**

**Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.**

Terdapat error Whitelabel karena template yang dibutuhkan pada baris return tidak ditemukan (belum dibuat). Saat baris return pada method addBioskop dijalankan, ia berusaha mencari template bernama "add-bioskop". Akan tetapi, karena belum ada template dengan nama tersebut, maka keluar Whitelabel error.

&nbsp;


**Pertanyaan 2: Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat.**

Menurut saya, anotasi @Autowired pada class Controller digunakan agar tidak perlu repot menggunakan setter dan getter, serta juga tidak perlu menggunakan argumen pada constructor class. Konsep tersebut merupakan fitur dari Spring. Dengan menggunakan anotasi @Autowired field yang ada akan diisi object yang sesuai secara otomatis oleh Spring.

&nbsp;



**Pertanyaan 3: Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut:** 

**http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx**

**Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.**

Saat mengakses link tersebut, terdapat Whitelabel error juga. Hal ini disebabkan karena terdapat parameter yang tidak ada pada URL tersebut, yaitu jumlahStudio. Parameter tersebut required sehingga akan ada error bila tidak ada pada URL saat method addBioskop dipanggil.

&nbsp;



**Pertanyaan 4: Jika Papa APAP ingin melihat Bioskop dengan nama Bioskop Maung, link apa yang harus diakses?**

Dengan asumsi Papa APAP mengetahui idBioskop dari Bioskop Maung, maka Papa APAP dapat mengakses URL berikut:

http://localhost:8080/bioskop/view/id-bioskop/[idBioskop]

Saat ingin mengakses URL tersebut, Papa APAP harus mengganti [idBioskop] dengan idBioskop dari Bioskop Maung.

&nbsp;



**Pertanyaan 5: Tambahkan 1 contoh Bioskop lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/bioskop/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.**

Saya menambahkan bioskop baru bernama Bioskop BaruuuP. Berikut adalah tampilan saat mengakses viewall.
![Screenshot viewall setelah bioskop ditambahkan](https://i.imgur.com/eci8EfE.png)


---
## Tutorial 1
### What I have learned today
Saya telah mempelajari tentang cara membuat *model* dan *controller* menggunakan Spring Boot. Saya juga telah mempelajari cara menggunakan *issue tracker* pada GitHub serta cara membuat *pull request*.
### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
Issue Tracker adalah fitur pada GitHub agar segala masalah yang ada dan akan di-*resolve* dapat di-*track* progresnya (terutama *bug*). Masalah yang dapat diselesaikan dengan Issue Tracker sangat beragam, *rule of thumb*-nya adalah masalah tersebut memerlukan perubahan kode pada *repository* dan/atau membutuhkan bantuan dari pihak lain yang terlibat pada proyek yang menggunakan *repository* tersebut.
2. Apa perbedaan dari git merge dan git merge --squash? git merge yaitu menggabungkan *branch* yang ada pada sekarang agar menyatu pada master. Apabila menggunakan squash, maka segala *commit* sebelumnya akan menyatu menjadi satu sehingga terlihat lebih rapi. Sedangkan bila tidak menggunakan squash maka commit akan terpisah-pisah dan terkesan berantakan.
3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan
suatu aplikasi? Version Control System (VCS) merupakan infrastruktur yang membantu para pengembang *software* agar dapat bekerja secara kolaboratif. Apabila ada beberapa pengembang *software* bekerja pada satu *software* yang sama, maka akan ada versi masing-masing, sehingga versi-versi tersebut harus disatukan menjadi satu menggunakan infrastruktur VCS.
### Spring
4. Apa itu library & dependency? Library merupakan sekumpulan *function* yang dapat ditambahkan secara kolektif ke program yang kita buat sehingga dapat dipanggil nantinya. Sedangkan, dependency adalah library-library yang dibutuhkan oleh sebuah program untuk dapat dijalankan karena program tersebut memanggil fungsi dari library-library tersebut.
5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven? Maven merupakan *build tool* yang banyak digunakan dalam proyek aplikasi Java. Maven membantu kita dalam mengompilasi *source code*, melakukan *testing*, dan menginstall *library* yang dibutuhkan. Walaupun sering digunakan pada Java, Maven juga dapat digunakan pada bahasa Kotlin, C#, Ruby, Scala, dan sebagainya.
6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring
framework? Framework Spring dapat membantu kita dalam membuat aplikasi enterprise, serta aplikasi yang berkaitan dengan big data.
7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable? @RequestParam mengekstrak nilai (query) dari URL, sedangkan @PathVariable mengambil nilai langsung dari URI-nya. 
### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda
sudah mengerti dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Kenapa saya harus belajar APAP?
- [ ] Kenapa APAP menggunakan Spring Boot dibanding yang lain?
