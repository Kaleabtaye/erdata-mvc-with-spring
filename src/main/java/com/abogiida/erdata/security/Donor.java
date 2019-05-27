package com.abogiida.erdata.security;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.abogiida.erdata.domains.Comment;
import com.abogiida.erdata.domains.FreeAid;
import com.abogiida.erdata.domains.Job;
import com.abogiida.erdata.domains.News;

import org.springframework.security.core.userdetails.UserDetails;
@Data
@Entity
@Table(name = "Donor")
public class Donor implements UserDetails{
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=8, message="Name must be at least 8 characters long")
	@Column(name ="name")
	private String name;
	
	@NotBlank(message="user name is required")
	@Column(name = "user_name")
	private String username;
	
	@NotNull
	@Size(min = 5 ,message = "passcode must be greater than 4 characters")
	@Column(name = "passcode")
	private String password;
	
	@Column(name = "enabled")
    private int enabled;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="donor_role",  
    			joinColumns= {@JoinColumn(name="donor_id")},
    			inverseJoinColumns= {@JoinColumn(name="role_id")})
    private Set<Role> roles;
	
	@ManyToMany(targetEntity = News.class)
	private List<News> news = new ArrayList<>();
	
	public void addNews(News news) {
		this.news.add(news);
	}
	
	@ManyToMany(targetEntity = Comment.class)
	private List<Comment> comments = new ArrayList<>();
	
	public void addComment(Comment comment) {
		this.comments.add(comment);
	}
	
	@ManyToMany(targetEntity = FreeAid.class)
	private List<FreeAid> freeAid =  new ArrayList<>();
	
	public void giveFreeAid(FreeAid freeAid) {
		this.freeAid.add(freeAid);
	}
	
	@ManyToMany(targetEntity = Job.class)
	private List<Job> jobs = new ArrayList<>();
	
	public void PostJob(Job job) {
		this.jobs.add(job);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = roles
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getRole()))
				.collect(Collectors.toSet());
		
		return authorities;
		
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() 	{
		// TODO Auto-generated method stub
		return true;
	}

}
