package com.dev0l.clockanize.configuration;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import java.time.*;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {

  @CreatedBy
  @Column(updatable = false)
  protected U createdBy;

  @CreatedDate
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(updatable = false)
  protected LocalDateTime createdDate;

  @LastModifiedBy
  protected U lastModifiedBy;

  @LastModifiedDate
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  protected LocalDateTime lastModifiedDate;

  public U getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(U createdBy) {
    this.createdBy = createdBy;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public U getLastModifiedBy() {
    return lastModifiedBy;
  }

  public void setLastModifiedBy(U lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
  }

  public LocalDateTime getLastModifiedDate() {
    return lastModifiedDate;
  }

  public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }

}