package edu.icet.service.system;

import edu.icet.dto.supplier.ProfilePreviousWorkImage;

import java.util.List;

public interface ProfilePreviousWorkImageService {

    ProfilePreviousWorkImage addPreviousWorkImage(ProfilePreviousWorkImage profilePreviousWorkImage);
    ProfilePreviousWorkImage updatePreviousWorkImage(ProfilePreviousWorkImage profilePreviousWorkImage);
    List<ProfilePreviousWorkImage>getAllPreviousWorkImage();
    void deleteByProfilePreviousWorkImageId(Long profilePreviousWorkImageId);
    ProfilePreviousWorkImage searchByProfilePreviousWorkImageId(Long profilePreviousWorkImageId );
}
