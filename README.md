

# Tutorial APAP
## Authors
* **Fariz Habibie Permana** - *1906305833* - *APAP-C*

---
## Tutorial 8
### Pertanyaan
**Pertanyaan 1: Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan mengapa kalian melakukan langkah - langkah tersebut?**

Dengan memanggil this.setState dan mengembalikan nilai state menjadi semula, isi form (input) menjadi kembali seperti semula pula. Langkah tersebut perlu dilakukan karena value awal dari setiap input diambil dari nilai state.

&nbsp;

**Pertanyaan 2: Jelaskan fungsi dari async dan await!**

Async berfungsi untuk menjalankan function secara asinkronis sehingga program tidak menunggu hasil dari function agar dapat lanjut berjalan. Akan tetapi, apabila terdapat await dalam sebuah function yang async, maka baris kode tersebut akan ditunggu hingga selesai (berjalan secara sinkronis) baru program lanjut berjalan.

&nbsp;

**Pertanyaan 3: Masukkan jawaban dari Screenshot yang diperintahkan di halaman 9 pada Component Lifecycle pada pertanyaan ini.**

![](https://i.imgur.com/8p6uEaT.png)
![](https://i.imgur.com/O6xNR0v.png)
![](https://i.imgur.com/E98MyVd.png)
![](https://i.imgur.com/djgW8hy.png)
![](https://i.imgur.com/ZTfGhdK.png)
![](https://i.imgur.com/uwz1SPh.png)
![](https://i.imgur.com/xWhyyMO.png)
![](https://i.imgur.com/EK0SbGl.png)
![](https://i.imgur.com/IInLZTt.png)

&nbsp;

**Pertanyaan 4: Jelaskan fungsi dari componentDidMount, shouldComponentUpdate, componentDidUpdate, componentWillReceiveProps, componentWillUnmount.**

componentDidMount dipanggil saat component sudah digunakan. Function ini berfungsi untuk mengambil data dari endpoint, umumnya untuk meng-initiate network request.

shouldComponentUpdate dipanggil saat render akan dipanggil (saat state dan props sudah diterima). Function ini memberikan informasi apakah component perlu diupdate berdasarkan state dan props yang ada dibandingkan dengan state dan props dari component yang sudah ada.

componentDidUpdate dipanggil saat component sudah ter-update, tujuannya yaitu untuk mengoperasikan DOM dari component setelah ter-update.

componentWillRecieveProps dipanggil saat sebelum render dilakukan, yaitu pada saat component menerima nilai props baru, tujuannya untuk memberikan informasi bahwa component akan menerima props baru.

componentWillUnmount dipanggil saat component akan dihilangkan atau dihapus. Tujuannya yaitu untuk memutus connection request yang ada dari componentDidMount.

&nbsp;


---
## Tutorial 7
### Pertanyaan
**Pertanyaan 1: Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan.**

Soal 1: Saya membuat fungsi baru untuk menghapus item dari cart yang dipanggil pada button delete dari cart. Pemanggilan function dapat dilihat dari screenshot berikut.


![Screenshot soal 1](https://i.imgur.com/HjHkhfF.png)

Soal 2: Saya membuat fungsi baru untuk menambah dan mengurangi balance berdasarkan harga item yang akan dimasukkan ke dalam cart. Pemanggilan function dapat dilihat dari screenshot berikut.


![Screenshot soal 2](https://i.imgur.com/fJTVqlZ.png)

Soal 3: Saya membuat constraint untuk tidak menambahkan item ke cart, terlihdat dari screenshot di atas. Constraint tersebut saya implementasikan ke dalam function untuk menambahkan item ke dalam cart. Implementasi tersebut dapat dilihat dari screenshot berikut.


![Screenshot soal 3](https://i.imgur.com/f4te04R.png)
&nbsp;

**Pertanyaan 2: Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?**

Pada functional component, tidak ada state dari komponen (stateless). State berlaku mirip seperti attribute dari objek, yaitu nilai private yang hanya dimiliki oleh objek tersebut. Sedangkan, prop merupakan attribute yang ada pada tag HTML. Dalam functional component, props merupakan parameter dari attribute. Sedangkan, dalam class componen, props merupakan attribute dari objek, dipanggil menggunakan 'this'.

&nbsp;

**Pertanyaan 3: Menurut kamu, apakah sebaiknya kita menggunakan component (e.g. List, Item) dalam React? sebutkan alasannya.**

Component dapat digunakan untuk mengurangi redudansi kode sehingga kode dapat menjadi lebih efisien dan rapi. Dengan begitu, developer dapat menjadi lebih mudah untuk menemukan bug yang ada dari program.

&nbsp;

**Pertanyaan 4: Apa perbedaan class component dan functional component?**

Terdapat state di dalam class component, sedangkan functional component tidak. Selain itu, class component membutuhkan render, sedangkan functional component tidak.

&nbsp;

**Pertanyaan 5: Dalam react, apakah perbedaan component dan element?**

Element merupakan object DOM beserta attributenya. Sedangkan, component merupakan function yang dapat menerima element dan dapat mereturn element pula. 

&nbsp;


---

## Tutorial 6
### Pertanyaan
**Pertanyaan 1: Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?**

Otentikasi adalah sistem keamanan yang memastikan bahwa pengguna memiliki credential di credentials storage pada sistem. Sedangkan, otorisasi adalah sistem keamanan yang membatasi akses pengguna berdasarkan rolenya. Pada tutorial ini, proses otentikasi ada pada WebSecurityConfig.java di dalam method configAuthentication. Sedangkan, proses otorisasi ada di pada file yang sama, namun pada method configure.

&nbsp;

**Pertanyaan 2: Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.**

BCryptPasswordEncoder adalah class yang bertujuan untuk meng-encode sebuah password agar terenkripsi sehingga memiliki keamanan yang lebih tinggi. Class ini merupakan implementasi dari PasswordEncoder yang menggunakan BCrypt yang memiliki function hashing yang kuat. Password dienkripsi menggunakan hashing BCrypt menjadi sebuah hash. Dengan begitu, password yang "mentah" tidak dapat dilihat secara langsung oleh pengguna.

&nbsp;

**Pertanyaan 3: Apakah penyimpanan password sebaiknya menggunakan encryption atau hashing? Mengapa demikian?**

Menurut saya, password sebaiknya menggunakan hashing. Hashing dan encryption memiliki dua tujuan berbeda. Hashing bertujuan untuk menjaga integritas data. Sedangkan, encryption bertujuan untuk menjaga keamanan data hingga sampai ke tempat tujuan. Password hanya bersifat satu arah, yaitu dikirim oleh pengguna dan akan dicek oleh sistem. Dengan begitu, kita tidak perlu men-decode password sehingga hashing adalah pilihan yang tepat.

&nbsp;

**Pertanyaan 4: Jelaskan secara singkat apa itu UUID beserta penggunaannya!**

UUID adalah singkatan dari Universally Unique Identifier, yaitu sebuah identifier yang terdiri dari 128-bit digit hexadecimal dan bersifat immutable serta di-generate secara random sehingga setiap UUID bersifat unik. UUID juga digunakan untuk membedakan objek secara unik dalam suatu sistem komputer berupa objek, token, maupun key database. 

Pada tutorial kali ini, UUID digunakan sebagai identifier untuk setiap objek user. Menggunakan UUID jauh lebih aman apabila dibandingkan dengan hanya menggunakan auto increment ID karena id dari user akan sulit untuk ditebak dan diretas.

&nbsp;

**Pertanyaan 5: Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah memiliki class UserRoleServiceImpl.java?**

UserDetailsService merupakan interface yang digunakan untuk mengambil sebuah data spesifik dari user. Interface ini hanya memiliki satu method, yaitu loadUserByUsername. Method tersebut implementasinya dapat kita sesuaikan dengan model yang kita miliki. Pada tutorial kali ini, kita meng-override method loadUserByUsername dan memberikan otentikasi serta otorisasi berdasarkan role-nya.

&nbsp;


---
## Tutorial 5
### Pertanyaan
**Pertanyaan 1: Apa itu Postman? Apa kegunaannya?**

Postman adalah sebuah aplikasi pihak ketiga yang berfungsi sebagai REST CLIENT untuk melakukan uji coba terhadap REST API, baik yang kita buat maupun milik orang lain. Postman juga digunakan oleh para developer yang membuat API sebagai tools untuk menguji API yang telah dibuat, atau untuk memelajari API milik developer lain.

&nbsp;

**Pertanyaan 2: Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty!**

**@JsonIgnoreProperties** berfungsi untuk mengabaikan properti logics mengenai serialize maupun deserialize dari JSON yang dianotasi di class-nya. @JsonIgnoreProperties memiliki beberapa elemen seperti allowSetters, allowGetters, ignoreUnknown dan value. Value dari anotasi tersebut menentukan nama properti yang akan diabaikan. @JsonProperty berfungsi untuk menandai metode setter/getter non-standar yang akan digunakan yang berhubungan dengan properti milik JSON.

&nbsp;

**Pertanyaan 3: Apa kegunaan atribut WebClient?**

WebClient berguna untuk menjadi poin dasar utama untuk API yang akan digunakan, dan akan menjadi dasar dalam memanggil API tersebut.

&nbsp;

**Pertanyaan 4: Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?**

ResponseEntity adalah anotasi yang mewakili seluruh respons dari HTTP. ResponseEntity dapat mengontrol semua attribute yang ada di dalamnya, seperti status, header, dan body. Tujuan utama ResponseEntity adalah untuk memberikan informasi di mana resource yang diubah. BindingResult berisi hasil validation dan nilai error yang dihasilkan saat melakukan validation. Agar dapat berfungsi, BindingResult harus muncul tepat setelah objek model yang divalidasi karena bila tidak berada di tepat setelah objek model tersebut Spring akan gagal untuk melakukan validation dari objek tersebut dan akan men-throw sebuah error message.

&nbsp;


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
