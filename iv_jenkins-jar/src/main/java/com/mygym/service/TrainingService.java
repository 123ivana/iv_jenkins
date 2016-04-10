
package com.mygym.service;

import javax.ejb.Local;

/**
 *
 * @author ivana
 */
@Local
public interface TrainingService {
    
    public String selectAll();
}
