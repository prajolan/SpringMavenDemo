package com.itn.Entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Users.class)
public abstract class Users_ {

	public static volatile SingularAttribute<Users, String> firstName;
	public static volatile SingularAttribute<Users, String> lastName;
	public static volatile SingularAttribute<Users, String> password;
	public static volatile SetAttribute<Users, UserProfile> userProfiles;
	public static volatile SingularAttribute<Users, Long> id;
	public static volatile SingularAttribute<Users, String> state;
	public static volatile SingularAttribute<Users, String> email;
	public static volatile SingularAttribute<Users, String> username;

}

