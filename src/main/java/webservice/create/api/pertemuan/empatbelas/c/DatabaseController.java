/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webservice.create.api.pertemuan.empatbelas.c;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author pascal
 */

@RestController
@RequestMapping(value = "/datamhs")

/**
 * kelas DatabaseController
 */
public class DatabaseController {

    @Autowired
    RepositoryMahasiswa repositoryMahasiswa;
    
    /**
     * Operasi menambahkan data ke dalam penyimpanan
     * @param param param sebagai parameternya
     * @return menampilkan hasil data yang telah disimpan ke dalam parameter param 
     */
    @PostMapping(value = "/addnewmhs")
    public Mahasiswadata addnewmhs(@RequestBody Mahasiswadata param)
    {
        repositoryMahasiswa.save(param);
        return param;
    }  
    
    /**
     * Operasi memanggil semua data
     * @return menampilkan semua hasil data 
     */
    @GetMapping(value = "/getallmhs")
    public List<Mahasiswadata> getallmhs()
    {
        return repositoryMahasiswa.findAll();
    }
    
    /**
     * Operasi memanggil data berdasarkan parameter id
     * @param id id sebagai parameternya
     * @return menampilkan hasil data sesuai dari permintaan parameter id nya
     */
    @GetMapping(value = "/getmhsbyid")
    public Mahasiswadata getmhsbyid(@RequestParam int id)
    {
        return repositoryMahasiswa.findById(id).get();
    }
    
    /**
     * Operasi pengeditan data yang telah tersimpan sebelumnya atau data yang mau diubah isinya
     * @param param param sebagai parameternya
     * @return menampilkan hasil data yang telah diubah dari data sebelumnya
     */
    @PutMapping(value = "/updatemhs")
    public Mahasiswadata updatemhs(@RequestBody Mahasiswadata param)
    {
        return repositoryMahasiswa.save(param);
    }
    
    /**
     * Operasi penghapusan data yang telah tersimpan
     * @param id id sebagai parameternya
     * @return menampilkan hasil data setelah adanya operasi penghapusan pada data mahasiswanya
     */
    @DeleteMapping(value = "/deletemhs")
    public List <Mahasiswadata> deletemhs(@RequestParam int id)
    {
        repositoryMahasiswa.deleteById(id);
        List<Mahasiswadata> mhslist = repositoryMahasiswa.findAll();
        return mhslist;
    }
}
    




