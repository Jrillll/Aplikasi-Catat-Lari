# CatatLari - Aplikasi Pencatat Riwayat Lari

Aplikasi CatatLari adalah platform sederhana yang dirancang untuk membantu pengguna mendokumentasikan aktivitas olahraga lari mereka secara terorganisir.

## 👤 Informasi Pembuat
- **Nama:**
1. Radithya Saka Candranata 24082010049
2. Maulana Ahmad Andika 24082010052
3. Muhammad Nazriel Nararya Arianto 24082010068
4. Muhammad Sheva Rifki Andhika 24082010078

## 📝 Deskripsi Aplikasi
CatatLari dibangun untuk memudahkan pengguna dalam memantau konsistensi olahraga mereka. Aplikasi ini memungkinkan pengguna untuk mencatat setiap sesi lari, termasuk detail jarak yang ditempuh dan durasi waktu, serta menyimpannya ke dalam database lokal sehingga riwayat lari dapat dilihat kembali kapan saja.

## ✨ Daftar Fitur
1. **Sistem Autentikasi:** 
   - Pengguna dapat mendaftarkan akun baru (Register).
   - Masuk ke aplikasi menggunakan email dan password yang telah terdaftar (Login).
2. **Manajemen Riwayat Lari (CRUD):**
   - **Tambah Data:** Mencatat tanggal, jarak (KM & Meter), serta durasi (Jam & Menit).
   - **Tampil Data:** Melihat daftar riwayat lari di halaman utama (Home).
   - **Update Data:** Mengupdate Data Profil Pengguna
   - **Hapus Data:** Menghapus catatan lari tertentu dari daftar riwayat.
3. **Manajemen Profil:**
   - Melihat detail akun.
   - Memperbarui nama dan password pengguna.
   - Menghapus akun secara permanen dari aplikasi.
4. **Data Persistence:** Menggunakan database lokal sehingga data tidak hilang saat aplikasi ditutup.

## ⚙️ Tech Stack
- **Bahasa Pemrograman:** Kotlin
- **Arsitektur:** MVVM (Model-View-ViewModel)
- **Database:** Room Persistence Library (SQLite)
- **Navigation:** Android Navigation Component
- **UI Framework:** Material Design & ViewBinding
- **Lifecycle:** LiveData & ViewModel (untuk reaktivitas data)
