package com.tneciv.poseidon.entity;

import java.util.Date;

public class Track {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column track.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column track.track_id
     *
     * @mbg.generated
     */
    private Integer trackId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column track.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column track.artist
     *
     * @mbg.generated
     */
    private String artist;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column track.cover_img
     *
     * @mbg.generated
     */
    private String coverImg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column track.album
     *
     * @mbg.generated
     */
    private String album;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column track.mp3_url
     *
     * @mbg.generated
     */
    private String mp3Url;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column track.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table track
     *
     * @mbg.generated
     */
    public Track(Integer id, Integer trackId, String name, String artist, String coverImg, String album, String mp3Url, Date createTime) {
        this.id = id;
        this.trackId = trackId;
        this.name = name;
        this.artist = artist;
        this.coverImg = coverImg;
        this.album = album;
        this.mp3Url = mp3Url;
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table track
     *
     * @mbg.generated
     */
    public Track() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column track.id
     *
     * @return the value of track.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column track.id
     *
     * @param id the value for track.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column track.track_id
     *
     * @return the value of track.track_id
     *
     * @mbg.generated
     */
    public Integer getTrackId() {
        return trackId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column track.track_id
     *
     * @param trackId the value for track.track_id
     *
     * @mbg.generated
     */
    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column track.name
     *
     * @return the value of track.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column track.name
     *
     * @param name the value for track.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column track.artist
     *
     * @return the value of track.artist
     *
     * @mbg.generated
     */
    public String getArtist() {
        return artist;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column track.artist
     *
     * @param artist the value for track.artist
     *
     * @mbg.generated
     */
    public void setArtist(String artist) {
        this.artist = artist == null ? null : artist.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column track.cover_img
     *
     * @return the value of track.cover_img
     *
     * @mbg.generated
     */
    public String getCoverImg() {
        return coverImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column track.cover_img
     *
     * @param coverImg the value for track.cover_img
     *
     * @mbg.generated
     */
    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg == null ? null : coverImg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column track.album
     *
     * @return the value of track.album
     *
     * @mbg.generated
     */
    public String getAlbum() {
        return album;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column track.album
     *
     * @param album the value for track.album
     *
     * @mbg.generated
     */
    public void setAlbum(String album) {
        this.album = album == null ? null : album.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column track.mp3_url
     *
     * @return the value of track.mp3_url
     *
     * @mbg.generated
     */
    public String getMp3Url() {
        return mp3Url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column track.mp3_url
     *
     * @param mp3Url the value for track.mp3_url
     *
     * @mbg.generated
     */
    public void setMp3Url(String mp3Url) {
        this.mp3Url = mp3Url == null ? null : mp3Url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column track.create_time
     *
     * @return the value of track.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column track.create_time
     *
     * @param createTime the value for track.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}