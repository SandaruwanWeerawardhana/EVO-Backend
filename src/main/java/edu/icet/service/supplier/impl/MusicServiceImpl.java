package edu.icet.service.supplier.impl;

import edu.icet.dto.Music;
import edu.icet.dto.Supplier;
import edu.icet.service.supplier.MusicService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor

public class MusicServiceImpl implements MusicService {
    private final List<Music> musicList=new ArrayList<>();
    private ModelMapper modelMapper;

    @Override
    public List<Music> getAll(Supplier supplier) {

        List<Music> result=new ArrayList<>();
        for(Music m:musicList){
            if(m.getSupplierId().equals(supplier.getProfileId())){
                result.add(m);
            }
        }
        return result;
    }

    @Override
    public boolean addMusic(Music music) {
        return music!=null&&musicList.add(music);
    }

    @Override
    public Music searchMusic(String qurey) {
        Long id=Long.parseLong(qurey);
        return musicList.stream()
                .filter(m -> m.getSupplierId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("MusicRepository not found"));
    }

    @Override
    public boolean updateMusic(Music music) {
        if(music==null||music.getSupplierId()==null) return false;

        for(Music m:musicList){
            if(m.getSupplierId().equals(music.getSupplierId())){
                int index=musicList.indexOf(m);
                musicList.set(index,music);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteMusic(Long id) {
        return musicList.removeIf(m->m.getSupplierId().equals(id));
    }
}
